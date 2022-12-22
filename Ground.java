package chart;

//classe java//
    import javax.swing.JPanel;
    import java.awt.*;
    import java.io.File;
    import javax.imageio.ImageIO;
    import java.awt.event.*;
    import java.io.ObjectInputStream;
    import java.io.ObjectOutputStream;
    import java.net.Socket;
//classe java//

//my class//
    import moteur.*;
    import ear.*;
//my class//

public class Ground extends JPanel{
    
    Matrice matrice;
    Joueur playerone;
    Joueur playertwo;
    Socket socket;

    public Ground(Matrice table,Joueur joueur1,Joueur joueur2,Socket socket){
        this.matrice=table;
        this.playerone=joueur1;
        this.playertwo=joueur2;
        this.socket=socket;
    }

    //methode set//
        public void setmatrice(Matrice table){
            this.matrice=table;
        }
    //methode set//

    //position graphiquement//  
        Position position=new Position();
    //position graphiquement//


    //enregistremet du boule selectionner//
        Ballselect ballselect=new Ballselect();
    //enregistremet du boule selectionner//

    //terrain de jeu//
        public void drawground(Graphics g){
                Graphics2D g2=(Graphics2D) g;
                BasicStroke line=new BasicStroke(4.6f);
                g2.setStroke(line);
                g2.drawRect(130,100,200,200);
                line=new BasicStroke(4.0f);
                g2.setStroke(line);
                g2.drawLine(130,100,330,300);
                g2.drawLine(330,100,130,300);
                g2.drawLine(130,200,330,200);
                g2.drawLine(230,100,230,300);
        }
    //terrain de jeu//


    //placer les vides//
        public void placeempty(){
            int[][] table=this.matrice.gettableau();
            int[][][] chartposition=this.position.getposition();
            
                for(int i=0;i<table.length;i++){
                    for(int j=0;j<table[0].length;j++){
                        if(table[i][j]==0){
                            Empty vide=new Empty(chartposition[i][j][0],chartposition[i][j][1]);
                            vide.draw();
                            this.add(vide);
                            //listener
                                vide.addMouseListener(new Listenerempty(this.matrice,this.ballselect,j,i,this,this.socket));
                        }
                    }
                }
        }
    //placer les vides//


    //placer les boules//
        public void placeball(Graphics g){
            int[][] table=this.matrice.gettableau();
            int[][][] chartposition=this.position.getposition();
                
                for(int i=0;i<table.length;i++){
                    for(int j=0;j<table[0].length;j++){
                        //white//
                            if(table[i][j]==1){
                                Ball ballwhile=new Ball(chartposition[i][j][0],chartposition[i][j][1],"white");
                                ballwhile.draw(g);
                                this.add(ballwhile);
                                //listener//
                                    ballwhile.addMouseListener(new Listenerball(j,i,ballselect,this.playerone));
                            }
                        //white//

                        //black//
                            if(table[i][j]==2){
                                Ball ballblack=new Ball(chartposition[i][j][0],chartposition[i][j][1],"black");
                                ballblack.draw(g);
                                this.add(ballblack);
                                ballblack.addMouseListener(new Listenerball(j,i,ballselect,this.playertwo));
                            }
                        //black//
                    }
                }
        }
    //placer les boules//
    
    
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        //image fond//
            try{
                Image img=ImageIO.read(new File("image/wood-1866659.jpg"));
                g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
            }catch(Exception e){}
        //image fond// 

        drawground(g);
        placeempty();
        placeball(g);
        repaint();
    }
}