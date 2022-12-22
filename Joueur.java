package moteur;

public class Joueur{
    
    String nom;
    int numero;
    
    public Joueur(String nom,int numero){
        this.setnom(nom);
        this.setnumero(numero);
    }

    //methode get//
        public String getnom(){
            return this.nom;
        }

        public int getnumero(){
            return this.numero;
        }
    //methode get//

    //methode set//
        public void setnom(String nom){
            this.nom=nom;
        }

        public void setnumero(int numero){
            this.numero=numero;
        }
    //methode set//
}