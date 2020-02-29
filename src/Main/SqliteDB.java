package Main;

import java.sql.*;


public class SqliteDB {
    Connection c = null;
    Statement stmt = null;

    SqliteDB()  {
        // try connect to DB
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MediaSystem.sqlite");
            System.out.println("Connected to DB succesfully!");
        } catch (Exception e)  {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listProfiles() {
        try {
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM profiles");

            while(rs.next()) {
                int id = rs.getInt("pro_id");
                String firstname = rs.getString("pro_fname");
                String lastname = rs.getString("pro_lname");
                int age = rs.getInt("pro_age");


                System.out.println(id + "" + firstname + "" + lastname + "" + age);
            }

        } catch (Exception e)  {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {

            System.out.println("Disconnected from database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}



