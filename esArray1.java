import java.util.*; // import the Scanner class
import java.util.ArrayList;
import java.util.Arrays;

public class esArray1 {
    public static void main(String[] args) {
        // array Nome
        ArrayList<String> arrayName = new ArrayList<String>();
        // array password
        ArrayList<String> arrayPassword = new ArrayList<String>();
        // array Età
        ArrayList<Integer> arrayAge = new ArrayList<Integer>();
        //Scanner
        Scanner dataString = new Scanner(System.in);
        Scanner nScan = new Scanner(System.in);
        // Variabili d'appoggio tmp
        String nameTmp = "";
        String passwordTmp = "";
        int ageTmp = 0;
        //n utenti
        System.out.println("Quanti utenti vuoi aggiungere?");
        int count = nScan.nextInt();
        // prende i 3 dati degli user
        for (int i = 0; i < count; i++) {
            System.out.println("Inserisci i dati dell'utente");
            System.out.println("Nome Utente");
            nameTmp = dataString.nextLine();
            System.out.println("Età Utente");
            ageTmp = nScan.nextInt();
            System.out.println("Inserisci la Password");
            passwordTmp = dataString.nextLine();
            //carico i dati del nuovo user
            System.out.println("Confermi i dati inseriti? 1 si, 2 no");
            if (nScan.nextInt() == 1) {
                arrayName.add(nameTmp);
                arrayAge.add(ageTmp);
                arrayPassword.add(passwordTmp);
            } else {
                i--;
            }
        }
        //Stampo i vari user
        for (int j = 0; j < count; j++) {
            System.out.println(arrayName.get(j) + " " + arrayAge.get(j));
        }

        System.out.println("Vuoi modificare i dati del tuo account? 1 si 2 no");
        if (nScan.nextInt()==1) {
            System.out.println("Cerca per nome");
            nameTmp = dataString.nextLine();
            int positionInArray = arrayName.indexOf(nameTmp);
            Boolean existElement = positionInArray>=0;
            System.out.println(existElement);
            if (existElement) {
                System.out.println("Ciao " + arrayName.get(positionInArray));
                System.out.println("Inserisci il tuo nuovo nome");
                nameTmp = dataString.nextLine();
                System.out.println("Inserisci la tua nuova età");
                ageTmp = nScan.nextInt();
                System.out.println("Confermi la Modifica? 1 si 2 no");
                if (nScan.nextInt()==1) {
                    System.out.println("Inserisci la password");
                    passwordTmp=dataString.nextLine();
                    if (passwordTmp.equals(arrayPassword.get(positionInArray))) {
                        arrayName.set(positionInArray,nameTmp);
                        arrayAge.set(positionInArray,ageTmp);
                        System.out.println("Modifiche effettuate "+ arrayName.get(positionInArray));
                    }else{
                        System.out.println("modifiche annullate");
                    }
                }
            }
            
        }
    }
}
