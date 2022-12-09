package listener;
import java.awt.event.*;

import back.*;
import graphique.*;

public class Listenerboule implements MouseListener{
    
    Pionselectioner pion;
    Pion newpion;
    Joueur joueur;


    public Listenerboule(Pionselectioner pion,Pion newpion,Joueur joueur){  
        this.pion=pion;
        this.newpion=newpion;
        this.joueur=joueur;
    }

    public void mouseClicked(MouseEvent e){
        this.pion.setpion(newpion);
        this.pion.setjoueur(joueur);
    }

    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

}