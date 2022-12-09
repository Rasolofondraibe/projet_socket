package back;
import graphique.*;

import java.io.Serializable;

public class Pion implements Serializable{
    int x;
    int y;
    
    public Pion(){}

    public Pion(int x,int y){
        this.setx(x);
        this.sety(y);
    }

    //methode set//
        public void setx(int x){
            this.x=x;
        }

        public void sety(int y){
            this.y=y;
        }
    //methode set//

    //methode get//
        public int getx(){
            return this.x;
        }

        public int gety(){
            return this.y;
        } 
    //methode get//
}