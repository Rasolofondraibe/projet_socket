package back;
import graphique.*;

public class Moteur{
    int[][] tableau;
    public Moteur(int[][] tableau){
        this.settableau(tableau);
    }

    //methode set//
        public void settableau(int[][] tableau){
            this.tableau=tableau;
        }
    //methode set//

    //methode get//
        public int[][] gettableau(){
            return this.tableau;
        }
    //methode get//

    //nombre de pion horrizontale//
        public int horrizontale(Joueur joueur){
            Pion reference=joueur.getlistepion()[0];
            int x=reference.getx();
            int y=reference.gety();
            int nombre=1;
            int[][] table=this.gettableau();
            while(x<2){
                x++;
                if(table[y][x]==joueur.getnumero()){
                    nombre++;
                }
            }
            x=reference.getx();
            while(x>0){
                x--;
                if(table[y][x]==joueur.getnumero()){
                    nombre++;
                }            
            }
            return nombre;
        }
    //nombre de pion horrizontale//

    //nombre pion verticale//
        public int verticale(Joueur joueur){
            Pion reference=joueur.getlistepion()[0];
            int x=reference.getx();
            int y=reference.gety();
            int nombre=1;
            int[][] table=this.gettableau();
            while(y<2){
                y++;
                if(table[y][x]==joueur.getnumero()){
                    nombre++;
                }
            }
            y=reference.gety();
            while(y>0){
                y--;
                if(table[y][y]==joueur.getnumero()){
                    nombre++;
                }
            }
            return nombre;
        }
    //nombre pion verticale//

    //nombre pion diagonale droite//
        public int diagonaledroite(Joueur joueur){
            Pion reference=joueur.getlistepion()[0];
            int x=reference.getx();
            int y=reference.gety();
            int nombre=1;
            int[][] table=this.gettableau();
            while(x<2){
                x++;
                y--;
                if(table[y][x]==joueur.getnumero()){
                    nombre++;
                }
            }
            x=reference.getx();
            y=reference.gety();
            while(x>0){
                x--;
                y++;
                if(table[y][x]==joueur.getnumero())
                    nombre++;
            }
            return nombre;
        }
    //nombre pion diagonale droite//

    //nombre pion diagonale gauche//
        public int diagonalegauche(Joueur joueur){
            Pion reference=joueur.getlistepion()[0];
            int x=reference.getx();
            int y=reference.gety();
            int nombre=1;
            int[][] table=this.gettableau();
            while(x<2){
                x++;
                y++;
                if(table[y][x]==joueur.getnumero()){
                    nombre++;
                }
            }
            x=reference.getx();
            y=reference.gety();
            while(x>0){
                x--;
                y--;
                if(table[y][x]==joueur.getnumero())
                    nombre++;
            }
            return nombre;
        }
    //nombre pion diagonale gauche//

    //verification totale//
        public int verification(Joueur joueur){
            int horrizontale=horrizontale(joueur);
            int verticale=verticale(joueur);
            int diagonaledroite=diagonaledroite(joueur);
            int diagonalegauche=diagonalegauche(joueur);
            int indice=0;
            if(horrizontale==3 || verticale==3 || diagonaledroite==3 || diagonalegauche==3){
                indice=1;
            }
            return indice;
        }
    //verification totale//

    //placer les pions//
        public void setpositionpion(Pion pion,int newx,int newy,Joueur joueur){
            int[][] table=this.gettableau();
            int x=pion.getx();
            int y=pion.gety();
            table[y][x]=0;
            tableau[newy][newx]=joueur.getnumero();
            pion.setx(newx);
            pion.sety(newy);
        }

        public void placerpion(Joueur joueur){
            Pion[] listepion=joueur.getlistepion();
            for(int i=0;i<listepion.length;i++){
                setpositionpion(listepion[i],listepion[i].getx(),listepion[i].gety(),joueur);
            }
        }
    //placer les pions//

    
}