package multiple;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays; 


import moteur.Joueur;
import moteur.Matrice;
import chart.Ground;


public class Client{
    static final String serverName = "localhost";
    static final int serverPort = 9999;
 
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(serverName, serverPort);
        System.out.println("Socket client: " + socket);
 
        System.out.println("Client a cree les flux");

        //players//
            Joueur playerone=new Joueur("Andrianampoinimerina",1);
            Joueur playertwo=new Joueur("Ralambo",2);
        //players//

        //matrice//
            int[][] tableau=new int[5][3];
            for(int i=0;i<tableau.length;i++){
                for(int j=0;j<tableau[0].length;j++){
                    tableau[i][j]=0;
                }
            }

            Matrice matrice=new Matrice(tableau);

            matrice.placepawn(playerone,0,0);
            matrice.placepawn(playerone,1,0);
            matrice.placepawn(playerone,2,0);
            matrice.placepawn(playertwo,0,4);
            matrice.placepawn(playertwo,1,4);
            matrice.placepawn(playertwo,2,4);
        //matrice//
        

        Ground ground=new Ground(matrice,playerone,playertwo,socket);
        Game game=new Game(playerone,playertwo,ground);
        
            Clientthread clientthread=new Clientthread(socket,game);
            clientthread.start();
    
    }
}