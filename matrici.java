public class matrici {
    public static void main(String[] arg){
        //creazione matrici
        int[][] myNumbers={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //stesso programma utilizzando for each
        /*System.out.println(myNumbers[0][2]);
        for(int i=0;i<2;i++){
            for(int j:myNumbers[i]){
                System.out.println(j);
            }
        }*/
        //stampa matrice 
        for(int i=0;i<myNumbers.length;i++){
            for(int j=0;j<(myNumbers[i].length);j++){
                System.out.print(myNumbers[i][j]+" ");
            }
            System.out.println("\n");
        }
    }

}
