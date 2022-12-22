package multiple;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.util.Vector;

import moteur.*;

public class Clientthread extends Thread{

    Socket socket;
    Game game;

    public Clientthread(Socket s,Game game){
        this.socket=s;
        this.game=game;
    }

    public void run(){
        try{ 
                while(true){
                        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());  
                        Matrice matricearrive=(Matrice)in.readObject();
                        game.getground().setmatrice(matricearrive);
                        game.getground().removeAll();    
                }

        }catch(Exception e){}       
    }

}