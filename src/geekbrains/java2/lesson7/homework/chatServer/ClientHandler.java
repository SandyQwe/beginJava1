package geekbrains.java2.lesson7.homework.chatServer;


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
                if (str != null && str.startsWith("/auth")) { // /auth login1 pass1
                    String login = str.split(" ")[1];
                    String pass = str.split(" ")[2];
                    String user = SQLHandler.getNickByLoginPass(login, pass);
                    if (user != null) {
                        nick = user;
                        sendMessage("abcd");
                        break;
                    } else sendMessage("Auth error");
                }
            }
            while (true) {
                String str = in.readUTF();
                if (str != null) {
                    if (str.equals("/end")) break;
                    System.out.println(nick + ": " + str);
                    owner.broadCastMessage(nick, str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                owner.broadCastMessage("server", "Client disconnected...");
                owner.unsubscribe(this);
                sock.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage (String message) {
        try {
            out.writeUTF(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
