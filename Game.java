package multiple;

import moteur.Joueur;
import chart.Ground;
import chart.Fenetre;

public class Game{

    Joueur playerone;
    Joueur playertwo;
    Ground ground;

    public Game(Joueur joueur1,Joueur joueur2,Ground plateau){
        this.playerone=joueur1;
        this.playertwo=joueur2;
        this.ground=plateau;
        Fenetre window=new Fenetre();
        window.add(ground);
        window.setVisible(true);
    }

    //methode get//
        public Ground getground(){
            return this.ground;
        }
    //methode get//

}