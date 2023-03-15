import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class ConnessioneDB{

    public static Connection CreateConnection(String url, String username, String password){
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("ERRORE di connessione al database");
            return null;
        }
    }

    public static void ExecuteQuery(String query, Connection connection) {
        if (connection == null)
            return;

        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("ERRORE " + e.getMessage());
        }
    }
}