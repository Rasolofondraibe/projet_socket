package listener;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays; 
import java.awt.event.*;

import back.*;

public class Action implements ActionListener{

    Socket socket;
    Joueur joueur;

    public Action(Socket socket,Joueur joueur){
        this.socket=socket;
        this.joueur=joueur;
    }

    /*public void componentResized(ComponentEvent e){}
    public void componentMoved(ComponentEvent e){}
    public void componentShown(ComponentEvent e){}*/
    //public void mouseExited(ComponentEvent e){}
    public void actionPerformed(ActionEvent e){
        try{
            System.out.println("click");
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(this.joueur);
            out.flush();
        }catch(Exception ex){}
    }

    


}