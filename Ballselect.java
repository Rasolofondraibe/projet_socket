package ear;

import moteur.Joueur;

public class Ballselect{
    int coordinatex;
    int coordinatey;
    Joueur player;

    public Ballselect(){}
    
    public Ballselect(int x,int y,Joueur joueur){
        this.setcoordinatex(x);
        this.setcoordinatey(y);
        this.setplayer(joueur);
    }

    //methode set//
        public void setcoordinatex(int x){
            this.coordinatex=x;
        }

        public void setcoordinatey(int y){
            this.coordinatey=y;
        }

        public void setplayer(Joueur joueur){
            this.player=joueur;
        }
    //methode set//

    //methode get//
        public int getcoordinatex(){
            return this.coordinatex;
        }

        public int getcoordinatey(){
            return this.coordinatey;
        }

        public Joueur getplayer(){
            return this.player;
        }
    //methode get//
}