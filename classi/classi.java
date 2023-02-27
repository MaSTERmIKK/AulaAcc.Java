package classi;
import java.util.Scanner;
import classi.Freni;
import classi.Motori;
import classi.Macchina;
public class classi {
    public static void main(String[] args) {
        boolean uscita=false;
        Scanner myOb=new Scanner(System.in);
        int selezione;
        do{
            System.out.println("Si vuole uscire o entrare?\n0:Exit\n1:Entra");
            selezione=myOb.nextInt();
            switch(selezione){
                case 1:
                Motori mot=new Motori();
                System.out.println("inserire numero pastiglie");
                selezione=myOb.nextInt();
                Freni fre=new Freni(selezione);
                int tar=(int)(Math.random()*11000);
                Macchina toiota=new Macchina(mot, fre, tar);
                case 0:
                    uscita=true;
                    break;
            }
        }while(uscita!=true);
    }
}
