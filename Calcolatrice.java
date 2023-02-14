import java.util.Scanner;

//Funzioni Math in Java

public class Calcolatrice
{
        public static void main(String [] args)
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
}