package classi;
import classi.Freni;
import classi.Motori;
public class Macchina {
    Motori m;
    Freni f;
    int tar;
    Macchina(Motori mo,Freni fr,int ta){
        m=mo;
        f=fr;
        tar=ta;
        System.out.println("Macchina creata con successo\nTarga:"+tar);
    }
}
