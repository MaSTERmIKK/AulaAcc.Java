// Iterazione while

import java.util.Scanner;
import java.util.Spliterators;

public class Loops {
    public static void main(String[] args) {

        // Dichiarazione variabili e Scanner
        Boolean startP = true;
        Scanner num = new Scanner(System.in);
        int numeroInserito = 0;
        Scanner stringaA = new Scanner(System.in);
        String inserimentoStringa;

        // Inizio ciclo
        while(startP=true && numeroInserito!=-1) {
        System.out.println("Inserisci un numero da 1 a 10. Digita '-1' per terminare");
        numeroInserito = num.nextInt();
        if(numeroInserito==-1) {
            System.out.println("Fine.");
            break;
        }
        if(numeroInserito%2==0){
            System.out.println("Il numero è pari, diviso 2 è: " +numeroInserito/2);
        } else { 
            System.out.println("Il numero è dispari, il resto è: " +numeroInserito%2);

        }
        // Inserimento stringa e Split quando l'utente inserisce "-"
        System.out.println("Inserisci una stringa");
        inserimentoStringa = stringaA.nextLine();
        String[] splString = inserimentoStringa.split("-");

        // Stampa della stringa divisa in 2
        System.out.println(splString[0]);
        System.out.println(splString[1]);

        // Errore in caso di inserimento maggiore di 10.
        if(numeroInserito>10){
            System.out.println("Errore! Inserisci un numero compreso fra 1 e 10.");
        }
        }
    }
    
}
