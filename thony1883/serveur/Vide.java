package graphique;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;

import back.Moteur;

public class Vide extends JPanel{
    int x;
    int y;

    public Vide(int x,int y){
        this.x=x;
        this.y=y;
    }

    public void dessiner(Graphics g){
        super.paint(g);
        try{
            BufferedImage myPicture=ImageIO.read(new File("circleWhite.png"));
            g.drawImage(myPicture,this.x-15,this.y-20,80,80,null);
            this.setBounds(this.x,this.y,50,50);
        }catch(Exception e){}
    }
}