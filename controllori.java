
import java.util.Scanner;

public class controllori {
    public static void main(String [] args)
    {
        //Scanner per la scelta dello script
        Scanner myScelta = new Scanner(System.in);

        //Chiedo in input quale script eseguire
        System.out.println("Quale script vuoi eseguire?\n1: Calcolatrice\n2: Calendario\n3: Conta o stampa stringa ");
        System.out.print("Inserire numero scelta: ");
        int scelta = myScelta.nextInt();

        //Switch che confronta la scelta inserita per lo script da eseguire
        switch (scelta)
        {
            case 1:
                //richiamo del metodo
                Calcolatrice();
                break;

            case 2:
                //richiamo del metodo
                Calendario();
                break;

            case 3:
                ContaEStampaStringa();
                break;
        }
        myScelta.close();
    }

    //script Calcolatrice
    static void Calcolatrice()
    {
         //Scanner per il primo numero
         Scanner myNum1 = new Scanner(System.in);
         //Chiedo in input il primo numero
         System.out.print("Inserire il primo numero: ");
        float primoNumero = myNum1.nextFloat();
 
         //Scanner per il secondo numero
         Scanner myNum2 = new Scanner(System.in);
         //Chiedo in input il secondo numero
         System.out.print("Inserire il secondo numero: ");
         float secondoNumero = myNum2.nextFloat();
 
         //Scanner per le opzioni da scegliere per la calcolatrice
         Scanner myOption = new Scanner(System.in);
         //Chiedo che operazione voglio eseguire
         System.out.print("Che operazione vuoi eseguire? (Premi 1 per sommare, 2 per sottrare, 3 per dividere, 4 per moltiplicare, 5 per il modulo): ");
         int opzione = myOption.nextInt();
         if (opzione == 1)   //se == 1, faccio la somma dei due numeri
         {
             //Eseguo la somma dei due numeri;
             float sommaNumeri = primoNumero + secondoNumero;
             System.out.println("L'operazione somma da come risultato: "+ sommaNumeri);
         }
         else if (opzione == 2)      //se == 2, sottraggo i due numeri
         {
             float sottraiNumeri = primoNumero - secondoNumero;
             System.out.println("L'operazione sosttrazione da come risultato: "+ sottraiNumeri);
         }
         else if (opzione == 3)      //se == 3, divido i due numeri
         {
             float dividiNumeri = primoNumero / secondoNumero;
             System.out.println("L'operazione divisione da come risultato: "+ dividiNumeri);
         }
         else if (opzione == 4)      //se == 4, moltiplico i due numeri
         {
             float moltiplicaNumeri = primoNumero * secondoNumero;
             System.out.println("L'operazione moltiplicazione da come risultato: "+ moltiplicaNumeri);
         }
         else if (opzione == 5)      //se == 5, operazione modulo tra i due numeri
         {
             float moduloNumeri = primoNumero % secondoNumero;
             System.out.println("L'operazione somma da come risultato: "+ moduloNumeri);
         }
         myOption.close();
         myNum1.close();
         myNum2.close();
    }

    //Script Calendario
    static void Calendario()
    {
        //Scanner per il giorno
        Scanner myDay = new Scanner(System.in);
        //Chido di inserire il numero della giornata, da 1 a 7
        System.out.println("Inserire il numero del giorno (da 1 a 7): ");
        int day = myDay.nextInt();

        //CSwitch case per il numero inserito del giorno 
        switch (day)
        {
            case 1:
            System.out.println("Monday");
            break;

            case 2:
            System.out.println("Tuesday");
            break;

            case 3:
            System.out.println("Wednesday");
            break;

            case 4:
            System.out.println("Thursday");
            break;

            case 5:
            System.out.println("Friday");
            break;

            case 6:
            System.out.println("Saturday");
            break;

            case 7:
            System.out.println("Sunday");
            break;
        }
        myDay.close();
    }

    static void ContaEStampaStringa()
    {
        //Chiedo se voglio avviare la conto in input
        System.out.print("Vuoi avviare la conta? (s / n): ");
        Scanner myRisp = new Scanner(System.in);
        //Inserisco in input la mia risposta
        String risposta = myRisp.nextLine();

        //Se la risposta è si
        if (risposta.equals("S") | risposta.equals("s"))
        {
            //Chiedo di inserire un numero in input
            System.out.print("Inserire un numero: ");
            Scanner myNum = new Scanner(System.in);
            //Inserisco un numero
            int num = myNum.nextInt();

            //La conta di i va da 1 al numero inserito in input
            for (int i = 1; i <= num; i++)
            {
                //Stampo i + 1 dopo ogni iterazione
                System.out.println(i);
            }
            myNum.close();
            myRisp.close();
            System.out.println("Conta terminata!!!");
        } 
        //Altrimenti se la risposta è no
        else if (risposta.equals("N") | risposta.equals("n"))
        {
            //Chiedo se voglio stampare una stringa
            System.out.print("Vuoi stampare un stringa? (s / n): ");
            //Inserisco la mia risposta in input
            String secondaRisposta = myRisp.nextLine();
            //Se la risposta è si
            if (secondaRisposta.equals("S") || secondaRisposta.equals("s"))
            {
                System.out.print("Inserire la stringa da stampare: ");
                Scanner myStr = new Scanner(System.in);
                //Inserisco la stringa in input
                String stampaStringa = myStr.nextLine();

                //stampo un carattere + spazio + carattere fino a esaurimento elementi della stringa
                for (int i = 0; i < stampaStringa.length(); i++) {
                    char c = stampaStringa.charAt(i);
                    System.out.print(c + " ");
                }
                myStr.close();
            }
            //Altrimenti se la risposta è no
            else if (secondaRisposta.equals("n") || secondaRisposta.equals("N"))
            {
                System.out.println("TERMINO IL PROGRAMMA!!!");
            }
        }
    }
}
