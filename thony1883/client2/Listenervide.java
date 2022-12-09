package listener;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays; 

import java.awt.event.*;

import back.*;
import graphique.*;

public class Listenervide implements MouseListener{

    Pionselectioner pion;
    int x;
    int y;
    Moteur tableau; 
    Plateau plateau;
    Socket socket;
    
    public Listenervide(Pionselectioner pion,int x,int y,Moteur tableau,Plateau plateau,Socket socket){
        this.pion=pion;
        this.x=x;
        this.y=y;
        this.tableau=tableau;
        this.plateau=plateau;
        this.socket=socket;
    }

    public void mouseClicked(MouseEvent e){
        this.plateau.removeAll();
        Pion p=pion.getpion();
        Joueur joueur=pion.getjoueur();
        this.tableau.setpositionpion(p,x,y,joueur);
        
        try{
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(joueur);
            out.flush();
        }catch(Exception ex){}   
    }

    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
}