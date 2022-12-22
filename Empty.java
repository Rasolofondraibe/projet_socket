package moteur;

import javax.swing.JPanel;

public class Empty extends JPanel{

    //position graphiquement//
        int chartpositionx;
        int chartpositiony;
    //position graphiquement//

    public Empty(int x,int y){
        this.chartpositionx=x;
        this.chartpositiony=y;
    }

    ///dessiner le panel//
        public void draw(){
            this.setBounds(this.chartpositionx,this.chartpositiony,50,50);
            this.setOpaque(false);
        } 
    ///dessiner le panel//

}