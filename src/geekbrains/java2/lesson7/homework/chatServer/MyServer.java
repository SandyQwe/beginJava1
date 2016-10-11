package geekbrains.java2.lesson7.homework.chatServer;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {

    private ServerSocket serv = null;
    private final int PORT = 8189;
    private ArrayList<ClientHandler> list;

    public MyServer(){

        try {
            list = new ArrayList<>();
            serv = new ServerSocket(PORT);
            SQLHandler.connect();
            System.out.println("Waiting for clients...");
            while(true) {
                Socket sock = serv.accept();
                System.out.println("Client connected");
                broadCastMessage("server", "New client connected...");
                ClientHandler ch = new ClientHandler(this, sock);
                list.add(ch);
                new Thread(ch).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void broadCastMessage(String nick, String message){
        for (ClientHandler o : list){
            o.sendMessage(nick + ": " + message);
        }
    }

    public synchronized void unsubscribe (ClientHandler o){
        list.remove(o);
    }
}
