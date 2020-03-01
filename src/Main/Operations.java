package Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Operations extends SqliteDB {

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
            System.out.println("Movie created succesfully");
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
            System.out.println("Movie removed succesfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void removeProfile() {
        try  {
            String deleteQuery = "DELETE FROM profiles WHERE pro_id = ?";
            PreparedStatement pst = c.prepareStatement(deleteQuery);

            pst.setString(1,"1");

            pst.executeUpdate();
            System.out.println("User removed succesfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void review() {
        try  {
            String reviewQuery = "INSERT INTO rating VALUES (?,?,?,?,?);";
            PreparedStatement pst = c.prepareStatement(reviewQuery);

            pst.setString(1,"1");
            pst.setString(2, "dummy");
            pst.setString(3,"200" );
            pst.setString(4, "100");
            pst.setString(5,"dumb" );

            pst.execute();
            System.out.println("Review created succesfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void avgReview() {
            try  {
                String avgQuery = "SELECT avg(rev_stars) AS avg FROM rating WHERE mov_id = ?;";
                PreparedStatement pst = c.prepareStatement(avgQuery);
                pst.setString(1,"1");
                ResultSet rs = pst.executeQuery();

                Integer avg = rs.getInt("avg");

                pst.execute();
                System.out.println("Average created succesfully");
                System.out.println(avg);

            } catch (Exception e)  {
            System.out.println("Error: " + e.getMessage());
        }
    }



}
