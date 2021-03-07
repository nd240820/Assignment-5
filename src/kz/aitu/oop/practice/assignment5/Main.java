package kz.aitu.oop.practice.assignment5;

import kz.aitu.oop.practice.assignment5.controllers.NecklaceController;
import kz.aitu.oop.practice.assignment5.data.PostgresDB;
import kz.aitu.oop.practice.assignment5.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment5.repositories.NecklaceRepository;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IStoneRepository;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String connectionUrl = "jdbc:postgresql://localhost:5432/My OOP assignment 5 - company";
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            con = DriverManager.getConnection(connectionUrl, "postgres", "0000");

            // The object of statement is responsible to execute queries with the database
            stmt = con.createStatement();

            // The executeQuery() method of Statement interface is used to execute queries
            // to the database. This method returns the object of ResultSet that can be
            // used to get all the records of a table that matches the sql statement
            rs = stmt.executeQuery("select * from stones");

            while (rs.next()) // Processing the result
                System.out.println(rs.getInt("id") + "  "
                        + rs.getString("name") + "  " + rs.getInt("cost")
                        + rs.getDouble("weight"));
        } catch (Exception e) {
            System.out.println("Exception occurred!");
        } finally {

            try { // Close connection - clean up the system resources
                con.close();
            } catch (Exception e) {
                System.out.println("Exception occurred!");
            }
        }

        System.out.println("Finished!");

        // Here you specify which DB and UserRepository to use
        // And changing DB should not affect to whole code
        IDB db = new PostgresDB();
        IStoneRepository repo = new NecklaceRepository(db);
        NecklaceController controller = new NecklaceController(repo);
        MyStore app = new MyStore(controller);
        app.start();
    }
}