package graphique;

import java.awt.*;
import javax.swing.*;

public class Dessin extends JPanel{
    public Dessin(){
    }

    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(150,320,100,20);
    }
}