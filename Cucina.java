import java.util.Scanner;

public class Cucina {

    public static Scanner inserimentoNome = new Scanner(System.in);
    public static String name;
    public static Scanner inserimentoCognome = new Scanner(System.in);
    public static String surname;
    public static int role;
    public static Boolean fine;
    public static Scanner risposta = new Scanner(System.in);
    public static String rispScelta;

    public static Cucina myName = new Cucina();
    public static Cucina mySurname = new Cucina();
    public static Cucina myRole = new Cucina();

    public static void main(String[] args){
        do {
            Scanner userChoice=new Scanner(System.in);
            int numChoice;
            System.out.println("Sei un [1]CLIENTE, [2] CHEF, [3]CHEF CAPO, [4]MAGAZZINIERE? Digita.");
            numChoice=userChoice.nextInt();
            switch(numChoice){
                case 1:
                login(1);
                break;
                case 2:
                login(2, 2);
                break;
                case 3:
                login(3, 3, 3);
                break;
                case 4:
                login(4, 4, 4, 4);
                break;
            }
            System.out.println("Vuoi terminare? Digita 'Ok' o 'No'");
            rispScelta=risposta.nextLine();
            if (rispScelta.equalsIgnoreCase("Ok")){
                fine=true;
            } else if (rispScelta.equalsIgnoreCase("No")) {
                for (int i=0;i<15;i++){
                    System.out.println("Sei un [1]CLIENTE, [2] CHEF, [3]CHEF CAPO, [4]MAGAZZINIERE? Digita.");
                    numChoice=userChoice.nextInt();
                    switch(numChoice){
                        case 1:
                        login(1);
                        break;
                        case 2:
                        login(2, 2);
                        break;
                        case 3:
                        login(3, 3, 3);
                        break;
                        case 4:
                        login(4, 4, 4, 4);
                        break;
                    }
                }
            }
        } while(fine!=true);
    }

    public static void login(int x){
        System.out.println("Inserisci il tuo nome");
        myName.name=inserimentoNome.nextLine();
        System.out.println("Inserisci il tuo cognome");
        mySurname.surname=inserimentoCognome.nextLine();
        myRole.role=1;
        System.out.println("Codice ruolo: "+myRole.role+"\nNome inserito: "+myName.name+"\nCognome inserito: "+mySurname.surname);
    }

    public static void login(int x, int y){
        System.out.println("Inserisci il tuo nome");
        myName.name=inserimentoNome.nextLine();
        System.out.println("Inserisci il tuo cognome");
        mySurname.surname=inserimentoCognome.nextLine();
        myRole.role=2;
        System.out.println("Codice ruolo: "+myRole.role+"\nNome inserito: "+myName.name+"\nCognome inserito: "+mySurname.surname);

    }

    public static void login(int x, int y, int z){
        System.out.println("Inserisci il tuo nome");
        myName.name=inserimentoNome.nextLine();
        System.out.println("Inserisci il tuo cognome");
        mySurname.surname=inserimentoCognome.nextLine();
        myRole.role=3;
        System.out.println("Codice ruolo: "+myRole.role+"\nNome inserito: "+myName.name+"\nCognome inserito: "+mySurname.surname);

    }

    public static void login(int x, int y, int z, int k){
        System.out.println("Inserisci il tuo nome");
        myName.name=inserimentoNome.nextLine();
        System.out.println("Inserisci il tuo cognome");
        mySurname.surname=inserimentoCognome.nextLine();
        myRole.role=4;
        System.out.println("Codice ruolo: "+myRole.role+"\nNome inserito: "+myName.name+"\nCognome inserito: "+mySurname.surname);
    }


}
