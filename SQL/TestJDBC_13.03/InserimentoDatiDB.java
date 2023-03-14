import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class InserimentoDatiDB {
    public static void main(String[] args) {
        Menu();
    }

    private static void Menu() {
        System.out.println("\nBenvenuto nella biblioteca delle meraviglie!!");
        while (true) {
            System.out.println("\nScegli l'operazione da fare:\n");
            int scelta = RilevaInputUtente(
                    "1) inserisci autore\n2) inserisci libro\n3) stampa autori\n4) stampa libri\n5) chiudi libreria");

            switch (scelta) {
                case 1:
                    SceltaInserimentoAutori();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("ADDIO!!!");
                    return;

                default:
                    System.out.println("Inserimento non valido - " + scelta);
                    break;
            }
        }
    }

    private static void SceltaInserimentoAutori() {
        String nome, nazione;
        int anno_nascita, anno_morte;

        // nome
        while (true) {
            nome = RilevaInputUtenteString("Inserisci il nome");
            if (nome.length() > 0) {
                try {

                    PreparedStatement st = ConnessioneDB
                            .CreateConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "root")
                            .prepareStatement("SELECT nome FROM autori WHERE nome LIKE(?)");

                    st.setString(1, nome);
                    ResultSet rs = st.executeQuery();
                    if (!rs.next())
                        break;
                } catch (Exception e) {
                    System.out.println("ERRORE nella ricerca dell'autore");
                }
            }

            System.out.println("Inserimento non valito.");
        }

        // anno nascita
        while (true) {
            anno_nascita = RilevaInputUtente("Inserisci l'anno di nascita");
            if (anno_nascita >= 0 && anno_nascita <= 2020)
                break;

            System.out.println("Inserimento non valito.");
        }

        // anno_morte
        while (true) {
            anno_morte = RilevaInputUtente("Inserisci l'anno di morte(0 se non è deceduto)");
            if ((anno_morte > 0 && anno_morte <= 2023) && anno_morte > anno_nascita)
                break;
            if (anno_morte == 0)
                break;

            System.out.println("Inserimento non valito.");
        }

        nazione = RilevaInputUtenteString("Inserisci nazione");

        InserisciAutore(nome, anno_nascita, anno_morte, nazione);

        System.out.println("Inserimento concluso");
    }

    // metodo inserimento autore
    private static void InserisciAutore(String nome, int anno_nascita, int anno_morte, String nazione) {

    }

    // metodo inserimento libri
    // lettura dall'utente
    private static int RilevaInputUtente(String frase) {
        try {
            Scanner myScanner = new Scanner(System.in);
            System.out.println(frase);
            int input = myScanner.nextInt();
            return input;
        } catch (Exception e) {
            return 0;
        }
    }

    private static String RilevaInputUtenteString(String frase) {
        try {
            Scanner myScanner = new Scanner(System.in);
            System.out.println(frase);
            String input = myScanner.nextLine();
            return input;
        } catch (Exception e) {
            return "";
        }
    }

    // stampa autori
    // stampa libri autore
    // stampa di un result set
    private void StampTable(ResultSet resSet) {
        try {
            ResultSetMetaData rsMetaData = resSet.getMetaData();
            System.out.println("_________________________________________________________________________________");
            while (resSet.next()) {// questo ciclo scorre tutte le righe
                for (int i = 1; i <= (rsMetaData.getColumnCount()); i++) {// scorre tutte le colonne per ogni riga
                    System.out.print(rsMetaData.getColumnName(i) + ": " + resSet.getString(i) + "|");
                }
                System.out.println("\n");
                System.out.println("_________________________________________________________________________________");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}