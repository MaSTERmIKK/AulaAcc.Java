package ristorante_object;

import java.util.Scanner;

public class RistoranteObject {
    public static void main(String[] args) {
        boolean exit = false;
        // inizializzo i piatti del menú
        Dish carbonara = new Dish("Carbonara", "Guanciale, uova, pecorino, parmigiano", 15);
        Dish tagliata = new Dish("Tagliata", "Carne di manzo, rucola, scaglie di grana", 30);
        int totalAmount = 0;
        // creo una istanza di Bill
        Bill sessionBill = new Bill();
        while (!exit) {
            System.out.println("Vuoi comprare un piatto o uscire?\n[1] Compra\n[2] Esci");
            Scanner scannerMenu = new Scanner(System.in);
            int userChoice = scannerMenu.nextInt();

            switch (userChoice) {
                case 1:
                    // chiedo l'username all'utente
                    System.out.println("Inserisci il nome utente");
                    Scanner scannerForName = new Scanner(System.in);
                    String userName = scannerForName.nextLine();
                    // creo un'istanza di User
                    User customer = new User(userName);
                    customer.budget = customer.getRandomBudget();
                    System.out
                            .println(
                                    "Ciao " + customer.name + "!" + " Il tuo budget é di " + customer.budget + " euro");

                    // loop per la richiesta delle ordinazioni
                    boolean exitFromMenu = false;
                    while (!exitFromMenu) {
                        System.out.println(
                                "Che piatto vuoi acquistare? \n[1]" + carbonara.nome + "\n[2]" + tagliata.nome
                                        + "\n[3] Esci");
                        Scanner scannerForDish = new Scanner(System.in);
                        int userDish = scannerForDish.nextInt();
                        // l'utente sceglie "carbonara"
                        if (userDish == 1) {
                            if (customer.budget >= carbonara.prezzo) {
                                customer.budget -= carbonara.prezzo; // aggiorno il budget dell'utente
                                sessionBill.provisionalBill += carbonara.prezzo; // aggiorno il conto provvisorio
                                System.out.println("Piatto acquistato correttamente");

                            } else {
                                System.out.println("Budget insufficiente, ti rimangono: " + customer.budget);
                            }
                        } else if (userDish == 2) { // l'utente sceglie "tagliata"
                            if (customer.budget >= tagliata.prezzo) {
                                customer.budget -= tagliata.prezzo; // aggiorno il budget dell'utente
                                sessionBill.provisionalBill += tagliata.prezzo;
                                System.out.println("Piatto acquistato correttamente");

                            } else {
                                System.out.println("Budget insufficiente, ti rimangono: " + customer.budget);
                            }
                        } else if (userDish == 3) { // l'utente decide di non acquistare piú
                            System.out.println("....Uscita.....");
                            totalAmount = sessionBill.provisionalBill;
                            exitFromMenu = true;
                        } else {
                            System.out.println("Opzione non disponibile");
                        }
                    }
                    break;
                case 2:
                    sessionBill.totalBill += totalAmount;
                    // stampo il totale speso della sessione
                    System.out.println("Totale speso " + sessionBill.totalBill + " euro");
                    System.out.println("Alla prossima!");
                    exit = true;
                    break;
                default:
                    System.out.println("Opzione non disponibile");
            }
        }
    }

}

class Dish {
    String nome;
    String ingredients;
    int prezzo;

    Dish(String nome, String ingredients, int price) {
        this.nome = nome;
        this.ingredients = ingredients;
        this.prezzo = price;
    }
}

class User {
    String name;
    int budget;

    User(String name) {
        this.name = name;
    }

    int getRandomBudget() {
        int min = 10; // valore minimo del budget
        int max = 50; // valore massimo del budget

        // Genero un budget tra i 10 e 50 euro
        int randomBudget = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return randomBudget;
    }
}

class Bill {
    int totalBill;
    int provisionalBill;
}
