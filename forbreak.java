import java.util.Scanner;
public class forbreak{
    public static void main(String[] arg){
        Scanner s=new Scanner(System.in);
        boolean uscita=false;
        String[] cars=new String[4];
        String[] ca=new String[4];
        int[] num={1,4,5,5};
        /*for(int i=0;i<10;i++){
            if(i==8){
                break;

            }else if(i%2==0){
                continue;
            }
            System.out.println(i);
        }*/
        
        //inserimento manuale
        /*System.out.println("nome?");
        cars[0]=s.nextLine();
        System.out.println("cognome?");
        cars[1]=s.nextLine();
        System.out.println("email?");
        cars[2]=s.nextLine();
        System.out.println("età?");
        cars[3]=s.nextLine();
        for(String l : cars){
            System.out.print("  "+l);
        }*/
        //inserimeto array
        System.out.println("\n");
        for(int j=0;j<4;j++){
            
            System.out.print("inserisci:  ");
            cars[j]=s.nextLine();
            }
            int x=0;
            int y=0;
            //stampa alternata array
        for(int j=0;j<(cars.length+num.length);j++){
        if(x<y){
            System.out.print(" "+cars[x]);
            x++;
        }else{
            System.out.print(" "+num[y]);
            y++;
        }
        
        
        }
        

    }
}