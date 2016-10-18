package geekbrains.java2.chat.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class MyServer {
    private ServerSocket serv = null;
    private final int PORT = 8189;
    private ArrayList<ClientHandler> list;

    MyServer() {
        try {
            list = new ArrayList<>();
            serv = new ServerSocket(PORT);
            SQLHandler.connect();
            System.out.println("Ожидаем клиентов...");
            while (true) {
                Socket sock = serv.accept();
                System.out.println("Client connected");
                broadCastMessage("server", "New client connected...");
                ClientHandler ch = new ClientHandler(this, sock);
                list.add(ch);
                new Thread(ch).start();
            }
        } catch (IOException e) {
            System.out.println("Проблемы с сервером");
        } finally {
            try {
                serv.close();
                System.out.println("Сервер закрыт");
            } catch (IOException e) {
                System.out.println("Проблемы с закрытием сервера");
            }
        }
    }

    public synchronized void broadCastMessage(String nick, String message){
        for (ClientHandler o : list){
            o.sendMessage(nick + ": " + message);
        }
    }

    synchronized void unsubscribe(ClientHandler o) {
        list.remove(o);
    }

    boolean isNickBusy(String nick) {
        for (ClientHandler o : list) {
            if (o.getNick().equals(nick))
                return true;
        }
        return false;
    }

    void personalMessage(ClientHandler from, String toNick, String msg) {
        for (ClientHandler o : list) {
            if (o.getNick().equals(toNick)) {
                o.sendMessage("from " + from.getNick() + ": " + msg);
                from.sendMessage("to " + toNick + ": " + msg);
                break;
            }
        }
    }
}
