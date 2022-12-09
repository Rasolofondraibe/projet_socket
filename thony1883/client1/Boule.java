package graphique;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.event.*;

import back.Pion;
import listener.*;
import graphique.*;

public class Boule extends JPanel{
    int x;
    int y;
    String couleur;
    public Boule(){}
    public Boule(int x,int y,String couleur){
        this.x=x;
        this.y=y;
        this.couleur=couleur;
        //this.setOpaque(false);
    }

    //methode set//
        public void setx(int x){
            this.x=x;
        }

        public void sety(int y){
            this.y=y;
        }
    //methode set//

    public void dessiner(Graphics g){
        super.paint(g);
        Position p=new Position();
        int[][][] tabposition=p.getposition();
        try{
            String namepict="";
            if(this.couleur.equals("noire"))
                namepict="130.png";
            if(this.couleur.equals("blanche"))
                namepict="130-30.png";
            BufferedImage myPicture=ImageIO.read(new File(namepict));
            g.drawImage(myPicture,tabposition[y][x][0],tabposition[y][x][1],50,50,null);
            this.setBounds(tabposition[y][x][0],tabposition[y][x][1],50,50);           
        }catch(Exception e){}
    }
}