
import java.util.Scanner;
public class dowhilees {
    public static void main(String[] args) {
        Scanner myObj=new Scanner(System.in);
        Scanner myObj1=new Scanner(System.in);
        boolean uscita=false;
        String password;
        int selezione, disp1,disp2,disp3;
        disp1=disp2=disp3=10;
        String[] ingred= new String[3];
        int[] prezzo= new int[3];
        int piattiComp,budget;
        piattiComp=0;
        budget=100;
        prezzo[0]=prezzo[1]=prezzo[2]=10;
        ingred[0]=ingred[1]=ingred[2]="pane,acqua e pomodoro";
    
        do{
            System.out.println("Il menù di oggi comprende 3 piatti:\nPasta e fagioli:1\nManzo al curry:2\nPatate al forno:3\nUscire:4\nModifica ingredienti: 5\nPiatti"+piattiComp);
            selezione =myObj.nextInt();
            switch(selezione){
                case 1:
                    
                    System.out.println("Il Piatto è fatto con "+ingred[selezione-1]+"\ne costa:"+prezzo[selezione-1]);
                    System.out.println("\nDisponibilità: "+disp1);
                    System.out.println("Vuoi comprare questo piatto? si=1   no=0");
                    selezione =myObj.nextInt();
                    if(selezione==1){
                        disp1--;
                        piattiComp++;
                        System.out.println("Piatto Acquistato!");
                    }
                    break;
                case 2:
                    System.out.println("Il Piatto è fatto con "+ingred[selezione-1]+"\ne costa:"+prezzo[selezione-1]);
                    System.out.println("\nDisponibilità: "+disp2);
                    System.out.println("Vuoi comprare questo piatto? si=1   no=0");
                    selezione =myObj.nextInt();
                    if(selezione==1){
                        disp2--;
                        piattiComp++;
                        System.out.println("Piatto Acquistato!");
                    }
                    break;
                case 3:
                    System.out.println("Il Piatto è fatto con "+ingred[selezione-1]+"\ne costa:"+prezzo[selezione-1]);
                    System.out.println("\nDisponibilità: "+disp3);
                    System.out.println("Vuoi comprare questo piatto? si=1   no=0");
                    selezione =myObj.nextInt();
                    if(selezione==1){
                        disp3--;
                        piattiComp++;
                        System.out.println("Piatto Acquistato!");
                    }
                    break;
                case 4:
                    uscita=true;
                    break;
                case 5:
                    System.out.println("Inserire Password");
                    password =myObj1.nextLine();
                    if(password.equals("ristorante")){
                        System.out.println("modificare prezzo e ingredienti di Piatto 1 2 3?");
                        selezione =myObj.nextInt();
                        switch(selezione){
                            case 1:
                            System.out.println("Quale prezzo:");
                            prezzo[selezione-1] =myObj.nextInt();
                            System.out.println("Inserire ingredienti");
                            ingred[selezione-1]=myObj1.nextLine();
                            break;
                            case 2:
                            System.out.println("Quale prezzo:");
                            prezzo[selezione-1] =myObj.nextInt();
                            System.out.println("Inserire ingredienti");
                            ingred[selezione-1]=myObj1.nextLine();
                            break;
                            case 3:
                            System.out.println("Quale prezzo:");
                            prezzo[selezione-1] =myObj.nextInt();
                            System.out.println("Inserire ingredienti");
                            ingred[selezione-1]=myObj1.nextLine();
                            break;
                            default:
                            System.out.println("piatto non valido");
                        }

                    }
                    break;
                default:
                    System.out.println("Piatto non esistente");

            }


        }while(uscita==false);
    }
    static void VisualizzaP(int piatto,int prez[],String in[]){
        switch(piatto){
            case 1:
                System.out.println("Il Piatto è fatto con "+in[piatto]+"\ne costa:"+prez[piatto]);
                break;
            case 2:
                System.out.println("Il Piatto è fatto con manzo,curry,lattuga\nCosto:40€");
                break;
            case 3:
                System.out.println("Il Piatto è fatto con patate,olio,rosmarino\nCosto:3,5€");
                break;
        }
    }
}
