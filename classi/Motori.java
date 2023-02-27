package classi;
import java.util.Scanner;
public class Motori {
    int cilindrata;
    String pistoni;
    Motori(){
        Scanner myO=new Scanner(System.in);
        System.out.println("Cilindra 1900 o 2000?");
        cilindrata=myO.nextInt();
        if(cilindrata==1900)
            pistoni="pistoni grandi";
        else
            pistoni="pistoni piccoli";
    }
}
