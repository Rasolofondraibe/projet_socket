package ear;

import java.awt.event.*;

import moteur.Joueur;


public class Listenerball implements MouseListener{
    
    int coordinatex;
    int coordinatey;
    Ballselect ballselect;
    Joueur player;

    public Listenerball(int x,int y,Ballselect ball,Joueur joueur){
        this.coordinatex=x;
        this.coordinatey=y;
        this.ballselect=ball;
        this.player=joueur;
    } 

    public void mouseClicked(MouseEvent e){
        ballselect.setcoordinatex(this.coordinatex);
        ballselect.setcoordinatey(this.coordinatey);
        ballselect.setplayer(this.player);

        System.out.println("boule selectionner x: "+ballselect.getcoordinatex());
        System.out.println("boule selectionner y: "+ballselect.getcoordinatey());
    }

    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

}