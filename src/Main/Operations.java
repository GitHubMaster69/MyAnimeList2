package Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Operations extends SqliteDB {

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
