import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
public class arryListEs {
    public static void main(String[] arg){
//dichiarazioni variabili e scanner
    String s;
    Scanner myObj=new Scanner(System.in);
    Scanner myObj1=new Scanner(System.in);
    Integer arrN[] = {1,2,3,4,5,6};
    String arr[]={"ciao","miao","bao"};
    boolean uscita=false;
    int selezione,n;
    //inizio ciclo programma
    do{
        //prima selezione
        System.out.println("Vuoi inserire o visualizzare l'array? \ninserire:1   \nVisuaizzare:2  \nUscire:0");
        selezione=myObj.nextInt();
        switch(selezione){
            
            case 1://inserimento con differenziazione int stringa
                System.out.println("1=String  2=int");
                selezione=myObj.nextInt();
                if(selezione==1){
                    System.out.println("Inserire la stringa");
                    s=myObj1.nextLine();
                    ArrayList<String> arrayListS = new ArrayList<String>(Arrays.asList(arr));
                    arrayListS.add(s);
                    arr = arrayListS.toArray(arr);
                }else{
                    System.out.println("inserire l'int");
                    n=myObj1.nextInt();
                    ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(arrN));
                    arrayList.add(n);
                    arrN = arrayList.toArray(arrN);
                }
                break;
                
            case 2://visualizzazione con differenziazione int stringa
                System.out.println("1=String  2=int");
                selezione=myObj.nextInt();
                if(selezione==1){
                    System.out.println("l'array stringa è\n"+Arrays.toString(arr));
                }else{
                    System.out.println("l'array stringa è\n"+Arrays.toString(arrN));
                }
                break;
                
            case 0://uscita
            uscita=true;
            break;
            default://controllo sull'inserimento
            System.out.println("Inserimento errato");
        }
    }while(uscita!=true);
    }
}