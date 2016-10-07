package geekbrains.java2.lesson6.homework.chatServer;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClientHandler implements Runnable {
    private Socket sock;
    private myServer owner;
    private DataInputStream in;
    private DataOutputStream out;

    public ClientHandler(myServer owner, Socket sock) {
        this.sock = sock;
        this.owner = owner;
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
                    System.out.println(str);
                    owner.broadCastMessage(str);
//                    out.writeUTF("echo: " + str);
//                    out.flush();

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                owner.broadCastMessage("Client disconnected...");
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
