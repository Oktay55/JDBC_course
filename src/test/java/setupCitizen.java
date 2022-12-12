import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class setupCitizen {

    static Connection connection;

    @BeforeClass
    public void setupConnection() throws SQLException {


        // JDBC URL
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/campusDB";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        connection = DriverManager.getConnection(url, username, password);

    }
    @AfterClass
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
