package geekbrains.java2.lesson6.homework.chatServer;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class myServer {

    private ServerSocket serv = null;
    private final int PORT = 8189;
    private ArrayList<ClientHandler> list;

    public myServer(){

        try {
            list = new ArrayList<>();
            serv = new ServerSocket(PORT);
            System.out.println("Waiting for clients...");
            while(true) {
                Socket sock = serv.accept();
                System.out.println("Client connected");
                broadCastMessage("New client connected...");
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

    public void broadCastMessage(String message){
        for (ClientHandler o : list){
            o.sendMessage(message);
        }
    }

    public synchronized void unsubscribe (ClientHandler o){
        list.remove(o);
    }

}
