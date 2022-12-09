package graphique;

import back.*;
import graphique.*;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays; 
import java.awt.event.*;

import listener.*;

public class Jeu{

    Joueur joueur1;
    Joueur joueur2;
    Socket socket;
    
    int[][] tableau=new int[3][3];
                Moteur table=new Moteur(tableau);
    public Jeu(Joueur joueur1,Joueur joueur2,Socket socket){

        this.setjoueur1(joueur1);
        this.setjoueur2(joueur2);
        this.socket=socket;
        //partie affichage//
                
                table.placerpion(joueur1);
                table.placerpion(joueur2);
                Plateau plateau=new Plateau(joueur1,joueur2,table,this.socket);
                Fenetre fenetre=new Fenetre();
                fenetre.add(plateau);
                fenetre.setVisible(true);           
        //partie affichage//
    }

    public void replace(){
        table.placerpion(joueur1);
                table.placerpion(joueur2);
    }

    //methode set//
        public void setjoueur1(Joueur joueur){
            this.joueur1=joueur;
        }

        public void setjoueur2(Joueur joueur){
            this.joueur2=joueur;
        }
    //methode set//

    //mehode get//
        public Joueur getjoueur1(){
            return this.joueur1;
        }

        public Joueur getjoueur2(){
            return this.joueur2;
        }
    //mehode get//
}