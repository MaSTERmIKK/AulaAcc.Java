import java.util.Scanner; // import the Scanner class

public class esercizio {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        int num_input;
        // Enter number to convert
        System.out.println("Enter number");
        num_input = num.nextInt();
        double conversione_double = num_input;
        float conversione_float = (float) num_input;
        // output numbers
        System.out.println("double: " + conversione_double);
        System.out.println("float: " + conversione_float);
        

        Scanner stringa = new Scanner(System.in);
        String stringa_input;

        // Enter String
        System.out.println("Enter String");
        stringa_input = stringa.nextLine();
        char prima_lettera = stringa_input.charAt(0);
        //Output Char
        System.out.println("Prima lettera è: " + prima_lettera);
        stringa.close();

        // prova boolean
        boolean prova_boolean=true;
        System.out.println(prova_boolean);
        System.out.print(!prova_boolean);

    }

}
