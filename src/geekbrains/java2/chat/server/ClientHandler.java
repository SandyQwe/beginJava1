package geekbrains.java2.chat.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket sock;
    private MyServer owner;
    private DataInputStream in;
    private DataOutputStream out;
    private String nick;

    public ClientHandler(MyServer owner, Socket sock) {
        this.owner = owner;
        this.sock = sock;
        this.nick = "";
        try {
            in = new DataInputStream(sock.getInputStream());
            out = new DataOutputStream(sock.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String str = in.readUTF();
                if (str != null) {
                    if (str.equals("/end")) break;
                    if (str.startsWith("/")) serviceCommandHandler(str);
                    else {
                        if (!nick.equals(""))
                            System.out.println(nick + ": " + str);
                        owner.broadCastMessage(nick, str);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void serviceCommandHandler(String command) {
        String[] commands = command.split(" ");
        switch (commands[0]) {
            case "/auth": {
                String login = commands[1];
                String pass = commands[2];
                String user = SQLHandler.getNickByLoginPass(login, pass);
                if (user != null) {
                    nick = user;
                    sendMessage("/auth complete");
                } else sendMessage("Auth error");
                break;
            }
            case "/changenick": {
                String newNick = commands[1];
                if (SQLHandler.changeNick(newNick, nick)) {
                    nick = newNick;
                    owner.broadCastMessage("server", "User " + nick + " change nickname to " + newNick);
                } else {
                    sendMessage("Nickname " + newNick + " already exist, nickname does not changed.");
                }
                break;
            }
            case "/end": {
                sendMessage("end");
                disconnect();
                break;
            }
            default: {
                sendMessage("Unknown command");
            }
        }
    }

    private void disconnect() {
        owner.broadCastMessage("server", "Client " + nick + " disconnected...");
        owner.unsubscribe(this);
        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
