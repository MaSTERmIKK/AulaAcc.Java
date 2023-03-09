import java.util.Scanner;

public class Menucalc {
    public static Scanner interi = new Scanner(System.in);

    public static void main(String[] args) {
        boolean esci = true;
        double risultato[] = { 0, 0, 0, 0 };
        int i = 0;
        while (esci) {
            try {
                System.out.println("Inserisci primo numero");
                double num1 = inseNum();
                System.out.println("Inserisci secondo numero");
                double num2 = inseNum();
                System.out.println(
                        "Quale operazione vuoi eseguire 1: addizione 2: sottrazione 3: moltiplicazione 4:divisione 5:esci vedi risultati");
                int scelta = (int) inseNum();
                switch (scelta) {
                    case 1:
                        risultato[i] = calco.addizione(num1, num2);
                        System.out.println("Risultato: " + risultato[i]);
                        i++;
                        break;
                    case 2:
                        risultato[i] = calco.sottrazione(num1, num2);
                        System.out.println("Risultato: " + risultato[i]);
                        i++;
                        break;
                    case 3:
                        risultato[i] = calco.moltiplicazione(num1, num2);
                        System.out.println("Risultato: " + risultato[i]);
                        i++;
                        break;
                    case 4:
                        risultato[i] = calco.divisione(num1, num2);
                        System.out.println("Risultato: " + risultato[i]);
                        i++;
                        break;
                    default:
                        esci = false;
                        break;

                }
            } catch (Exception e) {
                System.out.println("Memoria risultati piena");
            }
        }
        for (int y = 0; y < 4; y++) {
            System.out.println("Risultato n " + y + " " + risultato[y]);
        }

    }

    public static double inseNum() {
        boolean errore = true;
        double i = 0;
        do {
            try {
                i = interi.nextDouble();
                errore = false;
                break;
            } catch (Exception e) {
                System.out.println("ERRORE");
                interi.nextLine();
                errore = true;
            } finally {
                if (errore)
                    System.out.println("Hai sbagliato Riprova");
                else
                    System.out.println("Input corretto");
            }
        } while (errore);
        return i;
    }
}
