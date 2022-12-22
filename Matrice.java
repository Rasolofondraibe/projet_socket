package moteur;

//class java//
    import java.util.ArrayList;
    import java.io.*;
    import javax.swing.*;
//class java//

public class Matrice implements Serializable{

    int[][] tableau;
    
    public Matrice(int[][] tableau){
        this.settableau(tableau);
    }

    //methode get//
        public int[][] gettableau(){
            return this.tableau;
        }
    //methode get//

    //methode set//
        public void settableau(int[][] tableau){
            this.tableau=tableau;
        }
    //methode set//

    //mettre un pion//   
        public void placepawn(Joueur player,int x,int y){
            int[][] tableau=this.gettableau();
            tableau[y][x]=player.getnumero();
        }
    //mettre un pion//     

    //supprimer un pion//  
        public void deletepawn(int x,int y){
            int[][] tableau=this.gettableau();
            tableau[y][x]=0;
        }
    //supprimer un pion//  

    //verification horrizontale//

        //maka position misy joueur iray//

            //---indice 0 = x
            //---indice 1 = y
            public ArrayList<Integer> coordinateplayer(Joueur player){
                int number=player.getnumero();
                int[][] tableau=this.gettableau();
                ArrayList<Integer> registration=new ArrayList<Integer>();
                for(int i=0;i<tableau.length;i++){
                    for(int j=0;j<tableau[0].length;j++){
                        if(tableau[i][j]==number){
                            registration.add(j);
                            registration.add(i);
                            break;
                        }
                    }
                }
                return registration;
            }
        //maka position misy joueur iray//
        
        public int verificationhorizontal(Joueur player){
            ArrayList<Integer> primposition=coordinateplayer(player);
            int x=primposition.get(0);      //premier positioin a verifier
            int y=primposition.get(1);
            int[][] matrix=this.gettableau();  //matrice
            int number=player.getnumero();      //numero du joueur
            int account=1;
            for(int i=(x+1);i<3;i++){
                if(matrix[y][i]==number){
                    account++;
                }
            }
            for(int i=(x-1);i>=0;i--){
                if(matrix[y][i]==number){
                    account++;
                }
            }
            return account;
        }

    //verification horrizontale//

    //verification vertical//
        public int verificationvertical(Joueur player){
            ArrayList<Integer> primposition=coordinateplayer(player);
            int x=primposition.get(0);      //premier positioin a verifier
            int y=primposition.get(1);
            int[][] matrix=this.gettableau();  //matrice
            int number=player.getnumero();      //numero du joueur
            int account=1;
            for(int i=(y+1);i<3;i++){
                if(matrix[i][x]==number){
                    account++;
                }
            }
            for(int i=(y-1);i>=0;i--){
                if(matrix[i][x]==number){
                    account++;
                }
            }
            return account;
        }
    //verification vertical//

    //verification diagonal//
        //inclinaison droite//
            public int verificationdiagonalright(Joueur player){
                ArrayList<Integer> primposition=coordinateplayer(player);
                int x=primposition.get(0);      //premier positioin a verifier
                int y=primposition.get(1);
                int[][] matrix=this.gettableau();  //matrice
                int number=player.getnumero();      //numero du joueur
                int account=1;
                int ystorage=y;
                for(int i=(x+1);y>0 && i<3;i++){
                    y--;
                    if(matrix[y][i]==number){
                        account++;
                    }
                }
                y=ystorage;
                for(int i=(x-1);i>=0;i--){
                    y++;
                    if(matrix[y][i]==number){
                        account++;
                    }
                }
                return account;
            }
        //inclinaison droite//

        //inclinaison gauche//
            public int verificationdiagonalleft(Joueur player){
                ArrayList<Integer> primposition=coordinateplayer(player);
                int x=primposition.get(0);      //premier positioin a verifier
                int y=primposition.get(1);
                int[][] matrix=this.gettableau();  //matrice
                int number=player.getnumero();      //numero du joueur
                int account=1;
                int ystorage=y;
                for(int i=(x+1);i<3;i++){
                    y++;
                    System.out.println("x diagoanle "+i);
                    System.out.println("y diagoanle "+y);
                    if(matrix[y][i]==number){
                        account++;
                    }
                }
                y=ystorage;
                for(int i=(x-1);i>0&&y>0;i--){
                    y--;
                    if(matrix[y][i]==number){
                        account++;
                    }
                }
                return account;
            }
        //inclinaison gauche//
    //verification diagonal//

    //verification total si un joueur a gagner//

        public void restart(){
            int[][] table=this.gettableau();
            for(int i=0;i<table.length;i++){
                for(int j=0;j<table[0].length;j++){
                    table[i][j]=0;
                }
            }
            for(int i=0;i<table[0].length;i++){
                table[0][i]=1;
            }
            for(int i=0;i<table[0].length;i++){
                table[table.length-1][i]=2;
            }
        }

        public void win(Joueur player){
            int horrizontale=verificationhorizontal(player);
            int vertical=verificationvertical(player);
            int diagonalright=verificationdiagonalright(player);
            int diagonalleft=verificationdiagonalleft(player);

            //System.out.println("horrizontale "+horrizontale);
            //System.out.println("vertical "+vertical);
            System.out.println("diagonalright "+diagonalright);
            System.out.println("diagonalleft "+diagonalleft);


            JFrame frame=new JFrame();
            if(horrizontale==3 || vertical==3 || diagonalright==3 || diagonalleft==3){
                String message=player.getnom()+" a gagne la partie";
                JOptionPane.showMessageDialog(frame,message);  
                restart();
            }
        }
    //verification total si un joueur a gagner//
}