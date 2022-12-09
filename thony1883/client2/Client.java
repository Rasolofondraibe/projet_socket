package socket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays; 

import back.*;
import graphique.*;


public class Client {
    static final String serverName = "localhost";
    static final int serverPort = 9999;
 
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(serverName, serverPort);
        System.out.println("Socket client: " + socket);
 
        System.out.println("Client a cree les flux");

        
        int[][] tableau=new int[3][3];
        Moteur table=new Moteur(tableau);
        Pion[] listepion1=new Pion[3];
        listepion1[0]=new Pion(0,0);
        listepion1[1]=new Pion(1,0);
        listepion1[2]=new Pion(2,0);

        Joueur joueur1=new Joueur("thony",1,listepion1);

        Pion[] listepion2=new Pion[3];
        listepion2[0]=new Pion(0,2);
        listepion2[1]=new Pion(1,2);
        listepion2[2]=new Pion(2,2);

        Joueur joueur2=new Joueur("randria",2,listepion2);

        //partie affichage//
            Jeu jeu=new Jeu(joueur1,joueur2,socket);           
        //partie affichage//
 
        while(true){
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());  
            Joueur joueur=(Joueur)in.readObject();
            System.out.println("joueur tonga:"+ joueur.getnom());
            jeu.setjoueur1(joueur);
            jeu.replace();
        }

    }
}