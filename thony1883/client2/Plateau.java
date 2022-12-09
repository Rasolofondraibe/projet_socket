package graphique;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays; 
import java.awt.event.*;

import socket.*;

import back.*;
import listener.*;

public class Plateau extends JPanel{

    Joueur playerone;
    Joueur playertwo;
    Moteur tableau;
    Socket socket;
    Position position=new Position();

    public Plateau(Joueur playerone,Joueur playertwo,Moteur tableau,Socket socket){
        this.playerone=playerone;
        this.playertwo=playertwo;
        this.tableau=tableau;
        this.socket=socket;
    }   


    Pionselectioner pionselectioner=new Pionselectioner();


    //methode get//
        public Moteur gettableau(){
            return this.tableau;
        }
    //methode get//

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        //image fond//
            try{
                Image img=ImageIO.read(new File("wood-1866659.jpg"));
                g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
            }catch(Exception e){}
        //image fond//

        Graphics2D g2=(Graphics2D) g;
        BasicStroke line=new BasicStroke(4.6f);
        g2.setStroke(line);
        g2.drawRect(130,100,200,200);
        line=new BasicStroke(4.0f);
        g2.setStroke(line);
        g2.drawLine(130,100,330,300);
        g2.drawLine(330,100,130,300);
        g2.drawLine(130,200,330,200);
        g2.drawLine(230,100,230,300);
        
        //joueur 1//
            Pion[] listepion=playerone.getlistepion();
            for(int i=0;i<listepion.length;i++){
                Boule boule=new Boule(listepion[i].getx(),listepion[i].gety(),"noire");
                boule.addMouseListener(new Listenerboule(pionselectioner,listepion[i],playerone));
                this.add(boule);
                boule.dessiner(g);
                boule.setOpaque(false);
            }
        //joueur 1//

        //joueur 2//
            Pion[] listepion2=playertwo.getlistepion();
            for(int i=0;i<listepion2.length;i++){
                Boule boule=new Boule(listepion2[i].getx(),listepion2[i].gety(),"blanche");
                boule.addMouseListener(new Listenerboule(pionselectioner,listepion2[i],playertwo));
                this.add(boule);
                boule.dessiner(g);
                boule.setOpaque(false);
            }
        //joueur 2//

        //position vide//
            int[][] table=this.tableau.gettableau();
            int[][][] p=this.position.getposition();
            for(int i=0;i<table.length;i++){
                for(int j=0;j<table[0].length;j++){
                    if(table[i][j]==0){
                        Vide vide=new Vide(p[i][j][0],p[i][j][1]);
                        this.add(vide);
                        vide.addMouseListener(new Listenervide(pionselectioner,j,i,tableau,this,socket));
                        vide.dessiner(g);
                        vide.setOpaque(false);
                    }
                }
            }
        //position vide//
 
        repaint();
    }
}