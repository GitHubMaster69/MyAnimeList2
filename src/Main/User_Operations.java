package Main;

import java.sql.PreparedStatement;

public class User_Operations extends Operations {

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
}
