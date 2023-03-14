import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreazioneBiblioteca {
    public static void main(String[] args) {
        CreateDB(ConnessioneDB.CreateConnection("jdbc:mysql://localhost:3306/", "root", "root"));
        CreateTables(ConnessioneDB.CreateConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "root"));
    }

    private static void CreateDB(Connection connection) {
        if (connection == null)
            return;

        try {
            Statement st = connection.createStatement();
            st.execute("CREATE DATABASE biblioteca");

            System.out.println("Database generato");
        } catch (SQLException e) {
            System.out.println("ERRORE " + e.getMessage());
        }
    }

    private static void CreateTables(Connection connection) {
        StatementTable(
                "CREATE TABLE autori(nome varchar(50) primary key, anno_nascita int not null, anno_morte int default 0 not null, nazione varchar(50) not null);",
                connection);

        StatementTable(
                "CREATE TABLE libri(titolo varchar(50), autore varchar(50), anno_pb int not null, primary key(titolo, autore), foreign key (autore) references autori (nome));",
                connection);
        
         System.out.println("Inserimento tabelle terminato");
    }
    private static void StatementTable(String query, Connection connection) {
        if (connection == null)
            return;

        try {
            Statement stAutori = connection.createStatement();
            stAutori.execute(query);
        } catch (SQLException e) {
            System.out.println("ERRORE " + e.getMessage());
        }
    }
}