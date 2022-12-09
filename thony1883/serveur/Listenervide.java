package listener;

import java.awt.event.*;

import back.*;
import graphique.*;

public class Listenervide implements MouseListener{

    Pionselectioner pion;
    int x;
    int y;
    Moteur tableau; 
    Plateau plateau;
    
    public Listenervide(Pionselectioner pion,int x,int y,Moteur tableau,Plateau plateau){
        this.pion=pion;
        this.x=x;
        this.y=y;
        this.tableau=tableau;
        this.plateau=plateau;
    }

    public void mouseClicked(MouseEvent e){
        this.plateau.removeAll();
        Pion p=pion.getpion();
        Joueur joueur=pion.getjoueur();
        this.tableau.setpositionpion(p,x,y,joueur);
    }

    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
}