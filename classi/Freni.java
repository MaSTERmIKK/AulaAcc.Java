package classi;
import java.util.Scanner;
public class Freni {
    int pFrenata, nElementi;
    Freni(int e){
        Scanner myO=new Scanner(System.in);

        System.out.println("Scegliere potenza frenante: 500  600");
        pFrenata = myO.nextInt();
        nElementi=e;
        System.out.println("Freno creato con successo!");
    }
}
