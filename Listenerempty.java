package ear;

import java.awt.event.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import moteur.Matrice;
import moteur.Joueur;
import chart.Ground;

public class Listenerempty implements MouseListener{
    
    Matrice matrice;
    Ballselect ballselect;
    int selectx;
    int selecty;
    Ground ground;
    Socket socket;

    public Listenerempty(Matrice table,Ballselect ball,int x,int y,Ground plateau,Socket socket){
        this.matrice=table;
        this.ballselect=ball;
        this.selectx=x;
        this.selecty=y;
        this.ground=plateau;
        this.socket=socket;
    } 

    public void mouseClicked(MouseEvent e){
        this.ground.removeAll();
        int coordinatex=ballselect.getcoordinatex();
        int coordinatey=ballselect.getcoordinatey();
        Joueur player=ballselect.getplayer();

        this.matrice.placepawn(player,this.selectx,this.selecty);
        
        this.matrice.deletepawn(coordinatex,coordinatey);

        //si un joueur a gagne le jeu//
            this.matrice.win(player);
        //si un joueur a gagne le jeu//

        try{
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(this.matrice);
            out.flush();
        }catch(Exception ex){
            System.out.println(ex);
        } 
    }

    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

}