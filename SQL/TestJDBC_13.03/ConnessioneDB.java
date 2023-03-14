import java.sql.Connection;
import java.sql.DriverManager;

public class ConnessioneDB{

    public static Connection CreateConnection(String url, String username, String password){
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("ERRORE di connessione al database");
            return null;
        }
    }
}