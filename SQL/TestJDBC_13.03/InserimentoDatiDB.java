import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class InserimentoDatiDB {
    public static void main(String[] args) {
        Menu();
    }

    private static void Menu() {
        System.out.println("\nBenvenuto nella biblioteca delle meraviglie!!");

        Connection connection = ConnessioneDB.CreateConnection("jdbc:mysql://localhost:3306/biblioteca", "root",
                "root");

        if (connection == null) {
            System.out.println("ERRORE chiusura programma per connessione mancante");
            return;
        }

        while (true) {
            System.out.println("\nScegli l'operazione da fare:\n");
            int scelta = RilevaInputUtente("1) inserisci autore\n2) inserisci libro\n3) stampa autori\n4) stampa libri\n5) chiudi libreria");

            switch (scelta) {
                case 1:
                    SceltaInserimentoAutore(connection);
                    break;
                case 2:
                    SceltaInserimentoLibro(connection);
                    break;
                case 3:
                    SceltaStampaAutori(connection);
                    break;
                case 4:
                    SceltaStampaLibri(connection);
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

    private static void SceltaInserimentoAutore(Connection connection) {
        String nome, nazione;
        int anno_nascita, anno_morte;

        // nome
        while (true) {
            nome = RilevaInputUtenteString("Inserisci il nome");
            if (nome.length() > 0 && !AutorePresente(nome, connection))
                break;

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

        InserisciAutore(nome, anno_nascita, anno_morte, nazione, connection);

        System.out.println("Inserimento concluso");
    }

    private static void SceltaInserimentoLibro(Connection connection) {
        String titolo, autore;
        int anno_pb;

        // autore
        while (true) {
            autore = RilevaInputUtenteString("Inserisci il nome dell'autore del libro");
            if (AutorePresente(autore, connection))
                break;

            System.out.println("Inserimento non valito.");
        }

        // titolo
        titolo = RilevaInputUtenteString("Inserisci il titolo del libro");

        // anno_pb
        while (true) {
            anno_pb = RilevaInputUtente("Inserisci l'anno di pubblicazione");
            if (anno_pb >= 0 && anno_pb <= 2023)
                break;

            System.out.println("Inserimento non valito.");
        }

        InserisciLibro(titolo, autore, anno_pb, connection);

        System.out.println("Inserimento concluso");
    }

    // stampa autori
    private static void SceltaStampaAutori(Connection connection) {
        try {
            Statement stm = connection.createStatement();
            String query = "SELECT * FROM autori";

            StampTable(stm.executeQuery(query));
        } catch (Exception e) {
            System.out.println("ERRORE nel recupero degli autori");
        }
    }

    // stampa libri autore
    private static void SceltaStampaLibri(Connection connection) {
        try {
            String autore;
            boolean tuttiLibri;
            while (true) {
                autore = RilevaInputUtenteString("Inserisci il nome dell'autore oppure lascia in bianco per visualizzare tutti i libri");
                
                tuttiLibri = autore.length() == 0;
                if (AutorePresente(autore, connection) || tuttiLibri)
                    break;
    
                System.out.println("Inserimento non valito.");
            }

            Statement stm = connection.createStatement();
            String query;
            if(tuttiLibri)
                query = "SELECT * FROM libri";
            else 
                query = "SELECT * FROM libri WHERE autore LIKE('" + autore + "')";

            StampTable(stm.executeQuery(query));
        } catch (Exception e) {
            System.out.println("ERRORE nel recupero dei libri");
        }
    }

    /**
     * controllo della presenza di autore nella tabella autori.
     * @param autore autore da cercare.
     * @param connection connesione su cui eseguire la query di ricerca.
     * @return restituisce TRUE se trova l'autore.
     */
    private static boolean AutorePresente(String autore, Connection connection) {
        boolean autorePresente = false;

        try {
            PreparedStatement st = connection.prepareStatement("SELECT nome FROM autori WHERE nome LIKE(?)");

            st.setString(1, autore);
            ResultSet rs = st.executeQuery();

            if (rs.next())
                autorePresente = true;

        } catch (Exception e) {
            System.out.println("ERRORE nella ricerca dell'autore");
        }

        return autorePresente;
    }

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

    // metodo inserimento autore
    private static void InserisciAutore(String nome, int anno_nascita, int anno_morte, String nazione, Connection connection) {
        try {
            // region CON INSERT INTO
            /*
             * // -statement dinamico
             * String query = "INSERT INTO autori VALUE(?, ?, ?, ?)";
             * PreparedStatement stm = connection.prepareStatement(query,
             * ResultSet.TYPE_SCROLL_SENSITIVE,
             * ResultSet.CONCUR_UPDATABLE);
             * 
             * stm.setString(1, nome);
             * stm.setInt(2, anno_nascita);
             * stm.setInt(3, anno_morte);
             * stm.setString(4, nazione);
             * 
             * stm.executeQuery();
             * // -statement statico
             * String queryStatic;
             * 
             * queryStatic = "INSERT INTO autori VALUE(" + nome + ", " + anno_nascita + ", "
             * + anno_morte + ", " + nazione + ");";
             * queryStatic = String.format("INSERT INTO autori VALUE(%s, %d, %d, %s)", nome,
             * anno_nascita, anno_morte, nazione);
             * 
             * Statement stmStatic =
             * connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
             * ResultSet.CONCUR_UPDATABLE);
             * 
             * stmStatic.executeQuery(queryStatic);
             */
            // endregion

            // CON RESULT SET
            Statement stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM autori";
            // recuperare il result-set
            ResultSet rs = stm.executeQuery(query);
            // spostiamo il cursore del rs per l'inserimento
            rs.moveToInsertRow();
            // inseriamo i dati
            rs.updateString("nome", nome);
            rs.updateInt("anno_nascita", anno_nascita);
            rs.updateInt("anno_morte", anno_morte);
            rs.updateString("nazione", nazione);
            // aggiorniamo il db
            rs.insertRow();
            // ripristiniamo la posizione del cursore
            rs.moveToCurrentRow();

            System.out.println("\nInserimento autore avvenuto\n");
        } catch (SQLException e) {
            System.out.println("ERRORE nell'inserimento dell'autore");
        }
    }

    // metodo inserimento libri
    private static void InserisciLibro(String titolo, String autore, int anno_pb, Connection connection) {
        try {
            // CON RESULT SET
            Statement stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM libri";
            // recuperare il result-set
            ResultSet rs = stm.executeQuery(query);
            // spostiamo il cursore del rs per l'inserimento
            rs.moveToInsertRow();
            // inseriamo i dati
            rs.updateString("titolo", titolo);
            rs.updateString("autore", autore);
            rs.updateInt("anno_pb", anno_pb);
            // aggiorniamo il db
            rs.insertRow();
            // ripristiniamo la posizione del cursore
            rs.moveToCurrentRow();

            System.out.println("\nInserimento libro avvenuto\n");
        } catch (SQLException e) {
            System.out.println("ERRORE nell'inserimento del libro");
        }
    }

    // stampa di un result set
    private static void StampTable(ResultSet resSet) {
        try {
            ResultSetMetaData rsMetaData = resSet.getMetaData();
            int numColumn = rsMetaData.getColumnCount();

            System.out.println("\nTabella " + rsMetaData.getTableName(1));
            // stampa intestazione tabella
            for (int i = 1; i <= numColumn; i++) {
                System.out.print(rsMetaData.getColumnName(i) + " (" + rsMetaData.getColumnTypeName(i) + ") " + "| ");
            }

            System.out.println("\n _________________________________________________________________________________\n");

            while (resSet.next()) {// questo ciclo scorre tutte le righe
                for (int i = 1; i <= (rsMetaData.getColumnCount()); i++) {// scorre tutte le colonne per ogni riga
                    System.out.print(resSet.getString(i) + " | ");
                }
                System.out.println(
                        "\n_________________________________________________________________________________\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}