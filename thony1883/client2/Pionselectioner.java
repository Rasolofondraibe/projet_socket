package back;

public class Pionselectioner{

    Pion pion;
    Joueur joueur;

    public Pionselectioner(){}

    public Pionselectioner(Pion pion,Joueur joueur){
        this.pion=pion;
        this.joueur=joueur;
    }


    //methode get//
        public Pion getpion(){
            return this.pion;
        }

        public Joueur getjoueur(){
            return this.joueur;
        }
    //methode get//

    //methode set//
        public void setpion(Pion pion){
            this.pion=pion;
        }

        public void setjoueur(Joueur joueur){
            this.joueur=joueur;
        }
    //methode set//
}