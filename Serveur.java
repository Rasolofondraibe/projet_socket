package multiple;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.io.DataInputStream;

public class Serveur extends Thread {
    private static int port = 9999;
    private static DataInputStream dataInput;
    static final String serverName = "localhost";
    Vector<Socket> listeclient=new Vector<Socket>();
    int nombre=0;

    public Serveur() {
 
    }

    public static void main(String[] args)throws Exception {
        Serveur s = new Serveur();        
        s.start();
    }

    public void run() {
        try {
            ServerSocket serverS=new ServerSocket(port);
                while(true){
                    System.out.println("En attente d' une nouvelle connection .........");
                    Socket socket = serverS.accept();
                    listeclient.add(socket);
                    Treatment traitment=new Treatment(listeclient,socket);
                    traitment.start();
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
