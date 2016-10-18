package geekbrains.java2.chat.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class ClientHandler implements Runnable {
    private Socket sock;
    private MyServer owner;
    private DataInputStream in;
    private DataOutputStream out;
    private String nick;

    ClientHandler(MyServer owner, Socket sock) {
        this.owner = owner;
        this.sock = sock;
        this.nick = "";
        try {
            in = new DataInputStream(sock.getInputStream());
            out = new DataOutputStream(sock.getOutputStream());
        } catch (IOException e) {
            System.out.println("Проблема с созданием обработчиков потоков in и out(неизвестно у кого)");
        }
    }

    String getNick() {
        return nick;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String str = in.readUTF();
                if (str != null && str.startsWith("/auth")) {
                    String login = str.split(" ")[1];
                    String pass = str.split(" ")[2];
                    String user = SQLHandler.getNickByLoginPass(login, pass);
                    if (user != null) {
                        if (!owner.isNickBusy(user)) {
                            nick = user;
                            sendMessage("/authok " + nick);
                            owner.broadCastMessage("Сервер", nick + " подключился к чату");
                            break;
                        } else sendMessage("...Такой ник уже занят");
                    } else sendMessage("...Неверный логин/пароль");
                }
            }
            while (true) {
                String str = in.readUTF();
                if (str != null) {
                    if (str.startsWith("/")) {
                        if (str.equals("/end")) {
                            sendMessage("Вы вышли из чата");
                            sendMessage("/endsession");
                            break;
//                        } else if (str.startsWith("/changenick")) {
//                            String newNick = str.split(" ")[1];
//                            if (newNick.length() > 2 && SQLHandler.tryToChangeNick(nick, newNick)) {
//                                sendMessage("/nickchanged " + newNick);
//                                owner.broadCastMessage("Сервер", "Пользователь " + nick + " сменил ник на " + newNick);
//                                this.nick = newNick;
//                            } else {
//                                sendMessage("Невозможно поменять ник");
//                            }
//                        } else if (str.startsWith("/pm")) { // /pm geekbrains hello java
//                            String sto = str.split(" ")[1];
//                            String getmsg = str.substring(sto.length() + 5);
//                            owner.personalMessage(this, sto, getmsg);
//                            System.out.println("pm from " + this.getNick() + " to " + sto + ": " + getmsg);
                        } else serviceCommandHandler(str);
                    } else {
//                        if (!nick.equals(""))
                        System.out.println(nick + ": " + str);
                        owner.broadCastMessage(nick, str);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Обрыв соединения с клиентом");
        } finally {
            disconnect();
        }
    }

    void sendMessage(String message) {
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
//            case "/auth": {
//                String login = commands[1];
//                String pass = commands[2];
//                String user = SQLHandler.getNickByLoginPass(login, pass);
//                if (user != null) {
//                    nick = user;
//                    sendMessage("/auth complete");
//                } else sendMessage("Auth error");
//                break;
//            }
            case "/changenick": {
                String newNick = commands[1];
                if (newNick.length() > 2 && SQLHandler.tryToChangeNick(nick, newNick)) {
                    sendMessage("/nickchanged " + newNick);
                    owner.broadCastMessage("Сервер", "Пользователь " + nick + " сменил ник на " + newNick);
                    this.nick = newNick;
                } else {
                    sendMessage("Невозможно поменять ник");
                }
                break;
            }
            case "/pm": {
                String sto = commands[1];
                String getmsg = command.substring(sto.length() + 5);
                owner.personalMessage(this, sto, getmsg);
                System.out.println("pm from " + this.getNick() + " to " + sto + ": " + getmsg);
            }
//            case "/end": {
//                sendMessage("end");
//                disconnect();
//                break;
//            }
                default: {
                    sendMessage("Unknown command");
                }
            }
        }

    private void disconnect() {
        try {
            owner.broadCastMessage("server", "Client " + nick + " disconnected...");
            owner.unsubscribe(this);
            sock.close();
        } catch (IOException e) {
            System.out.println("Проблема с закрытием сокета");
        }
    }
}
