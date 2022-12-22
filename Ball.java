package chart;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.io.File;

public class Ball extends JPanel{

    //position graphiquement//
        int chartpositionx;
        int chartpositiony;
        String color;       //color de la boule du joueur
    //position graphiquement//

    public Ball(int x,int y,String couleur){
        this.chartpositionx=x;
        this.chartpositiony=y;
        this.color=couleur;
    }

    //dessiner la boule//
        public void draw(Graphics g){
            super.paint(g);
            try{
                String picturename="";
                if(this.color.equals("black"))
                    picturename="image/black.png";
                if(this.color.equals("white"))
                    picturename="image/white.png";
                BufferedImage myPicture=ImageIO.read(new File(picturename));
                g.drawImage(myPicture,this.chartpositionx,this.chartpositiony,40,40,null);
                this.setBounds(this.chartpositionx,this.chartpositiony,50,50);           
                this.setOpaque(false);
            }catch(Exception e){}
        }
    //dessiner la boule//
}