import org.testng.annotations.Test;

import javax.xml.transform.Result;
import java.sql.*;

public class feature_Citizen extends setupCitizen {

    @Test
    public void test1() throws SQLException {

        Statement statement = connection.createStatement();

        ResultSet allCustomers = statement.executeQuery("SELECT * FROM citizenships WHERE citizenshipsId = 12");

        allCustomers.next(); // cursor is on the first row
        System.out.println(allCustomers.getString("citizenshipsId"));
        System.out.println(allCustomers.getString("citizenshipsName"));
        System.out.println(allCustomers.getString("citizenshipsShortName"));
        System.out.println();


    }

//    @Test
//    public static void main (String[] args) {
//
//        try {
//            Statement statement = connection.createStatement();
//
//            statement.executeUpdate("INSERT INTO citizenships " +
//                    "VALUES (101, 'Toffee', 'Saglam')");
//
//
//        } catch (Exception e) {
//            System.out.println("Got an exception! ");
//            System.out.println(e.getMessage());




    @Test
    public void test4() throws SQLException {

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);



        int allCustomer = statement.executeUpdate("INSERT INTO citizenships " +
                "VALUES (17, 'Toffee', 'Saglam')");

        ResultSet allCustomers = null;
        allCustomers.absolute(17); // cursor is on row 25
        System.out.println(allCustomers.getString("citizenshipsId"));
        System.out.println(allCustomers.getString("citizenshipsName"));
        System.out.println(allCustomers.getString("citizenshipsShortName"));

    }
}


