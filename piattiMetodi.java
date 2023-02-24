package cicli;
import java.util.Scanner;
import java.util.ArrayList;

//import javax.lang.model.util.ElementScanner6;
public class piattiMetodi {
    public static void main(String[] args) {
        ArrayList<String> nome =new ArrayList<String>();
        ArrayList<String> ingrediente1 =new ArrayList<String>();
        ArrayList<String> ingrediente2 =new ArrayList<String>();
        ArrayList<Double> prezzo =new ArrayList<Double>();
        ArrayList<Integer> disponibilita =new ArrayList<Integer>();

        nome.add(0,"panino Caddozzone");
        ingrediente1.add(0,"pane");
        ingrediente2.add(0,"salsiccia");
        prezzo.add(0,5.99);
        disponibilita.add(0,20);
        nome.add(1,"panino Bidda");
        ingrediente1.add(1,"pane");
        ingrediente2.add(1,"cipolle");
        prezzo.add(1,5.99);
        disponibilita.add(1,20);
        double vendite=0;
        int numeroCli=0, comp=0,  numeroPiatti=2;
        Scanner scelta = new Scanner(System.in);
        Scanner scelta2 = new Scanner(System.in);
        Scanner verifica = new Scanner(System.in);
        Scanner scelte4 = new Scanner(System.in);
        Scanner compra = new Scanner(System.in);
        String scel, scel4="si";

        do{
            System.out.println("digita si per entrare nel secondo menu 2 per uscire");
            scel= scelta.nextLine();
            //guardiamo se vuole ordinare
            switch(scel){
            case "si":
                //diamo il budget
                double budget=(Math.random() + 10)*10;
                numeroCli++;
                do{
                    //qua avremmo il secondo menu
                    System.out.println("seleziona 1 per compra, 2 per vedi, 3 per scelta, 4 per esci ");
                    int secondoM= scelta2.nextInt();
                    switch(secondoM){
                    case 1:
                        for(int i=0;i<numeroPiatti;i++){
                            if(budget>=prezzo.get(i) && disponibilita.get(i)>0){
                                System.out.println(nome.get(i)+" prezzo: "+ prezzo.get(i)+" gli ingredienti di questo piatto sono: "+ ingrediente1.get(i)+" "+ingrediente2.get(i));
                                System.out.println("vuoi comprarlo?: 1 si, 2 no");
                                comp= compra.nextInt();
                                if(comp==1){
                                    
                                    disponibilita.set(i,disponibilita.get(i)-1);
                                    budget=budget-prezzo.get(i);
                                    vendite=vendite+prezzo.get(i);
                                }
                                
                            }else{
                                System.out.println("non hai abbastanza soldi per comprare "+nome.get(i));
                            }
                        }
                            
                    break;

                    case 2:
                            System.out.println("digita 1 pervisualizzare 2 per modificare");
                            int sceltaDiff= verifica.nextInt();
                            switch (sceltaDiff){
                                case 1:
                                    System.out.println("I piatti sono: ");
                                     for(int i=0;i<numeroPiatti;i++){
                                        System.out.print(nome.get(i)+": ");
                                        System.out.print(ingrediente1.get(i)+" ");
                                        System.out.print(ingrediente2.get(i)+" ");
                                        System.out.println(prezzo.get(i)+" ");
                                     }
                                break;
                                case 2:
                                    Scanner verifica3 = new Scanner(System.in);
                                    System.out.println("Scrivere 1 per aggiungere piatto, 2 per modificare un piatto esistente, 3 per eliminare un piatto");
                                    int sceltaDifficile= verifica3.nextInt();
                                    switch(sceltaDifficile){
                                        case 1:
                                        
                                            Scanner nuovo = new Scanner(System.in);
                                            System.out.println("Digitare nome nuovo piatto: ");
                                            nome.add(numeroPiatti+1,nuovo.nextLine());
                                            System.out.println("Digitare primo nuovo ingrediente per nuovo piatto: ");
                                            ingrediente1.add(numeroPiatti+1,nuovo.nextLine());
                                            System.out.println("Digitare secondo nuovo ingrediente per nuovo piatto: ");
                                            ingrediente2.add(numeroPiatti+1,nuovo.nextLine());
                                            System.out.println("Digitare prezzo nuovo piatto: ");
                                            prezzo.add(numeroPiatti+1,nuovo.nextDouble());
                                            numeroPiatti++;
                                        break;
                                        
                                        case 2:
                                            Scanner modifica = new Scanner(System.in);
                                            System.out.println("Digitare il numero del piatto da modificare: ");
                                            int r=modifica.nextInt();
                                            System.out.println("Digitare il numero del piatto da modificare: ");
                                            nome.set(r,modifica.nextLine());
                                            System.out.print("Digitare primo nuovo ingrediente per nuovo piatto: ");
                                            ingrediente1.set(r,modifica.nextLine());
                                            System.out.println("Digitare secondo nuovo ingrediente per nuovo piatto: ");
                                            ingrediente2.set(r,modifica.nextLine());
                                            System.out.println("Digitare prezzo nuovo piatto: ");
                                            prezzo.set(r,modifica.nextDouble());
                                        break;
                                        case 3:
                                            Scanner elimina = new Scanner(System.in);
                                            System.out.println("Digitare il numero del piatto da modificare: ");
                                            int d=elimina.nextInt();
                                            System.out.println("Digitare il numero del piatto da modificare: ");
                                            nome.remove(d);
                                            System.out.println("Digitare primo nuovo ingrediente per nuovo piatto: ");
                                            ingrediente1.remove(d);
                                            System.out.println("Digitare secondo nuovo ingrediente per nuovo piatto: ");
                                            ingrediente2.remove(d);
                                            System.out.println("Digitare prezzo nuovo piatto: ");
                                            prezzo.remove(d);
                                        break;
                                    }
                                break;
                                case 3:
                                    scel4="siMa";
                                break;
                                }
                            

                    break;
                }
                }while(scel4.equals("si"));
                        
                    
                    
            break;
            default:
                scel="no";
            break;
            }
        }while(scel.equals("si"));
        System.out.println("Ci sono stati: "+numeroCli+" ,i soldi che i clienti hanno speso sono: "+vendite);
        scelta.close();
        scelta2.close();
        verifica.close();
        scelte4.close();
        compra.close();               
    }
}