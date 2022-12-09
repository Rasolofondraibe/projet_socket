package socket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.io.DataInputStream;

import back.*;
import graphique.*;

public class Traitment extends Thread{

    Socket socket;
    Joueur[] tableaujoueur=new Joueur[2];

    public Traitment(Socket socket)throws Exception{
        this.socket=socket;
                
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
        tableaujoueur[0]=joueur1;
        tableaujoueur[1]=joueur2;
    }

    public void run(){
        try{
            while(true){
                ObjectInputStream in = new ObjectInputStream(this.socket.getInputStream());  
                Joueur joueur=(Joueur)in.readObject();
                System.out.println("Joueur nalefa: "+joueur.getnom());  


                ObjectOutputStream out = new ObjectOutputStream(this.socket.getOutputStream());
                if(joueur.getnumero()==1){
                    tableaujoueur[0]=joueur;
                    out.writeObject(tableaujoueur[1]);
                }else{
                    tableaujoueur[1]=joueur;
                    out.writeObject(tableaujoueur[0]);
                }    

                 
                 //for(int i=0;i<tableaujoueur.length;i++){
                 //}   
                    
                out.flush();
            }
        }catch(Exception ex){}
    }

}