package multiple;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.util.Vector;

import moteur.Matrice;


public class Treatment extends Thread{

    
    Vector<Socket> listeclient;
    Socket socket;

    public Treatment(Vector<Socket> listeclient,Socket socket)throws Exception{
        this.listeclient=listeclient;
        this.socket=socket;
    }

    public void run(){
        try{
        while(true){
            ObjectInputStream in = new ObjectInputStream(this.socket.getInputStream());  
            Matrice matrice=(Matrice)in.readObject();
            for(int k=0;k<listeclient.size();k++){                                  

                int[][] table=matrice.gettableau();

                ObjectOutputStream out = new ObjectOutputStream(this.listeclient.get(k).getOutputStream());
       
                out.writeObject(matrice);
                
                out.flush();
            }
        }
        }catch(Exception ex){}
    }

}