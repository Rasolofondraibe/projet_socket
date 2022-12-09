package graphique;

public class Position{
    int[][][] position;
    public Position(){
        position=new int[3][3][2]; 
        position[0][0][0]=105;
        position[0][0][1]=80;
        position[0][1][0]=205;
        position[0][1][1]=80;
        position[0][2][0]=305;
        position[0][2][1]=80;
        
        position[1][0][0]=105;
        position[1][0][1]=180;
        position[1][1][0]=205;
        position[1][1][1]=180;
        position[1][2][0]=305;
        position[1][2][1]=180;

        position[2][0][0]=105;
        position[2][0][1]=280;
        position[2][1][0]=205;
        position[2][1][1]=280;
        position[2][2][0]=305;
        position[2][2][1]=280;
    }

    //methode get//
        public int[][][] getposition(){
            return this.position;
        }
    //methode get//
}