
import java.util.Scanner;
public class Esercizio2 {
    public static void main(String[] args) {
        //creazione scanner
            Scanner myObj = new Scanner(System.in);
            //Inserimento numero per la selezione
            System.out.println("inserire 1 se si vuole utilizzare la calcolatrice e 2 se si vuole il calendario");
            int numero = myObj.nextInt();
            //Switch di selezione
            switch(numero){
                case 1:
                    Calcolatrice();
                    break;
                case 2:
                    Calendario();
                    break;
            }
        }



        //classe calcolatrice
    static void Calcolatrice(){
        String operazione;
        int datoA,datoB;
        //creazione scanner
        Scanner myObj = new Scanner(System.in);
        Scanner myObj1 = new Scanner(System.in);
        Scanner myObj2 = new Scanner(System.in);
        //Inserimento numeri e selezione operazione
        System.out.println("inserire il numero");
        datoB = myObj.nextInt();
        System.out.println("inserire il secondo numero");
        datoA = myObj1.nextInt();
        System.out.println("inserire il l'operazione");
        operazione = myObj2.nextLine();
        //Selezione e esecuzione delle operazione
        if(operazione.equalsIgnoreCase("+")){
                System.out.println(datoB+datoA);
        }else if(operazione.equalsIgnoreCase("-")){
                System.out.println(datoB-datoA);

        }else if(operazione.equalsIgnoreCase("*")){
               System.out.println(datoB*datoA);

        }else if(operazione.equalsIgnoreCase("%")){
                System.out.println(datoB%datoA);
        }else{
                System.out.println("errore di operazione");
            }
        }




        //creazione calendario
    static void Calendario(){
        Scanner myScan=new Scanner(System.in);
        System.out.println("Inserire il numero e ti verra detto il giorno");
        //Switch di selezione 
        switch(myScan.nextInt()){
            case 1:
                System.out.println("Lunedi");
                break;
            case 2:
                System.out.println("martedi");
                break;
            case 3:
                System.out.println("Mercoledi");
                    break;                
            case 4:
                System.out.println("Giovedi");
                    break;
            case 5:
                System.out.println("Venerdi");
                    break;
            case 6:
                System.out.println("Sabato");
                    break;
            case 7:
                System.out.println("Domenica");
                    break;
                    default:
                    System.out.println("errore");
                    
            }
        }
    }
   