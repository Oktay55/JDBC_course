import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

public class LearningJDBC {

    Connection connection;

    @BeforeClass
    public void setupConnection() throws SQLException {


        // JDBC URL
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/classicmodels";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        connection = DriverManager.getConnection(url, username, password);

    }

    @Test
    public void test() throws SQLException {

        Statement statement = connection.createStatement();

        ResultSet allCustomers = statement.executeQuery("SELECT * FROM customers");

        allCustomers.next(); // cursor is on the first row
        System.out.println(allCustomers.getString("customerName"));
        System.out.println(allCustomers.getString("phone"));
        System.out.println(allCustomers.getString("country"));
        System.out.println();

        allCustomers.next(); // cursor is on the second row
        System.out.println(allCustomers.getString("customerName"));
        System.out.println(allCustomers.getString("phone"));
        System.out.println(allCustomers.getString("country"));


    }

    @Test
    public void test2() throws SQLException {

        Statement statement = connection.createStatement();

        ResultSet allProducts = statement.executeQuery("SELECT * FROM products");

        allProducts.next();
        System.out.println(allProducts.getString("productName"));

        allProducts.next();
        System.out.println(allProducts.getString("productName"));

        allProducts.next();
        System.out.println(allProducts.getString("productName"));

    }

    @Test
    public void test3() throws SQLException {

        Statement statement = connection.createStatement();

        ResultSet allEmployees = statement.executeQuery("SELECT * FROM employees");

        while (allEmployees.next()) {
            System.out.println("FirstName: " + allEmployees.getString("firstName"));
            System.out.println("JobTitle: " + allEmployees.getString("jobTitle"));
            System.out.println("**********************");
        }


    }

    @Test
    public void test4() throws SQLException {

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet allCustomers = statement.executeQuery("SELECT * FROM customers");

        allCustomers.absolute(25); // cursor is on row 25
        System.out.println(allCustomers.getString("CustomerName"));
        System.out.println(allCustomers.getString("country"));

        System.out.println("*******************************************");

        allCustomers.absolute(10); // cursor is on row 25
        System.out.println(allCustomers.getString("CustomerName"));
        System.out.println(allCustomers.getString("country"));

        System.out.println("*******************************************");

        allCustomers.last(); // cursor on the last row
        System.out.println(allCustomers.getString("CustomerName"));
        System.out.println(allCustomers.getString("country"));

        System.out.println("*******************************************");

        allCustomers.first(); // cursor on the first row
        System.out.println(allCustomers.getString("CustomerName"));
        System.out.println(allCustomers.getString("country"));


    }

    @AfterClass
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
