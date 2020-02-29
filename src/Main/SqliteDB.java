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

    public void createMovie() {
        try  {
            String createQuery = "INSERT INTO movie VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement pst = c.prepareStatement(createQuery);

            pst.setString(1,"1"); //mov id
            pst.setString(2, "dummy"); //mov_title
            pst.setString(3, "100"); //mov_year
            pst.setString(4,"123" ); //mov_time
            pst.setString(5, "d"); //mov_lang
            pst.setString(6,"123" ); //mov_dt_rel
            pst.setString(7,"ded" ); //mov_rel_country
            pst.setString(8,"ded" ); //mov_rel_country
            //pst.setBytes(8,);

            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void removeMovie() {
        try  {
            String deleteQuery = "DELETE FROM movie WHERE mov_id = ?";
            PreparedStatement pst = c.prepareStatement(deleteQuery);

            pst.setString(1,"1");

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void review() {
        try  {
            String query2 = "INSERT INTO movie VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement pst = c.prepareStatement(query2);

            pst.setString(1,"1");
            pst.setString(2, "dummy");
            pst.setString(3,"200" );
            pst.setString(4, "100");
            pst.setString(5,"dumb" );
            pst.setString(6, "2000");
            pst.setString(7,"ded" );
            //pst.setBytes(8,);

            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}



