package back;

import java.io.Serializable;

public class Joueur implements Serializable{
    String nom;
    int numero;
    Pion[] listepion;

    public Joueur(){}

    public Joueur(String nom,int numero,Pion[] listepion){
        this.setnom(nom);
        this.setnumero(numero);
        this.setlistepion(listepion);
    }

    //methode set//
        public void setnom(String nom){
            this.nom=nom;
        }

        public void setnumero(int numero){
            this.numero=numero;
        }

        public void setlistepion(Pion[] listepion){
            this.listepion=listepion;
        }
    //methode set//

    //methode get//
        public String getnom(){
            return this.nom;
        }

        public int getnumero(){
            return this.numero;
        }

        public Pion[] getlistepion(){
            return this.listepion;
        }
    //methode get//
}