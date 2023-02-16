import java.util.Scanner;

public class EsercizioFor {
    public static void main(String[] args) {
        Scanner num_1 = new Scanner(System.in);
        Scanner num_2 = new Scanner(System.in);
        Scanner num_3 = new Scanner(System.in);
        Scanner scelta = new Scanner(System.in);
        Scanner stringa = new Scanner(System.in);

        System.out.println("inserira una stringa");
        String stringaInput = stringa.nextLine();
        System.out.println("inserire 3 numeri");
        int num_1_input = num_1.nextInt();
        int num_2_input = num_1.nextInt();
        int num_3_input = num_1.nextInt();
        System.out.println("Quale numero vuoi contare? 0 Per Stringa");
        int scelta_input = scelta.nextInt();

        switch (scelta_input) {

            case 0:
                int lung = stringaInput.length();
                for (int i = 0; i < lung; i++) {
                    System.out.println("Lettera numero: " + (i + 1) + " " + stringaInput.charAt(i));
                }
                break;
            case 1:
                for (int i = 1; i <= num_1_input; i++) {
                    System.out.println(i);

                }
                break;
            case 2:
                for (int i = 1; i <= num_2_input; i++) {
                    System.out.println(i);

                }
                break;
            case 3:
                for (int i = 1; i <= num_3_input; i++) {
                    System.out.println(i);

                }
                break;
            default:
                System.out.println("Uscita programma");
        }

    }
}
