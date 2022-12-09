// package affiche;
// import graphique.*;
// import back.*;

// public class Affichage{
//     public static void main(String[] args){

//         int[][] tableau=new int[3][3];
//         Moteur table=new Moteur(tableau);
//         Pion[] listepion1=new Pion[3];
//         listepion1[0]=new Pion(0,0);
//         listepion1[1]=new Pion(1,0);
//         listepion1[2]=new Pion(2,0);


//         Joueur joueur1=new Joueur("thony",1,listepion1);
//         table.placerpion(joueur1);

//         Pion[] listepion2=new Pion[3];
//         listepion2[0]=new Pion(0,2);
//         listepion2[1]=new Pion(1,2);
//         listepion2[2]=new Pion(2,2);

//         Joueur joueur2=new Joueur("randria",2,listepion2);
//         table.placerpion(joueur2);
//         Plateau plateau=new Plateau(joueur1,joueur2,table);
//         Fenetre fenetre=new Fenetre();

//         fenetre.add(plateau);
//         fenetre.setVisible(true);
//     }

// }