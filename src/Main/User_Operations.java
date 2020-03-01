package Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User_Operations extends Operations {

    public void review() {
        try  {
            String reviewQuery = "INSERT INTO rating (rev_id, mov_id, rev_stars, pro_id) SELECT ?,?,?, session.pro_id FROM session;";
            PreparedStatement pst = c.prepareStatement(reviewQuery);
            pst.setInt(1,3);
            pst.setInt(2, 3);
            pst.setInt(3,3);

            pst.execute();
            System.out.println("Review created succesfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addFavorite() {
        try  {
            String addFavQuery = "INSERT INTO favorites (pro_id, mov_sta_id, mov_id) SELECT session.pro_id FROM session, ?,?;";
            PreparedStatement pst = c.prepareStatement(addFavQuery);

            pst.setString(1, "dummy"); //mov_sta_id
            pst.setString(2, "100"); //mov_id

            pst.execute();
            System.out.println("Favorite added succesfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void removeFavorite() {
        try  {
            String remFavQuery = "DELETE FROM favorites WHERE mov_id = ?";
            PreparedStatement pst = c.prepareStatement(remFavQuery);

            pst.setString(1,"1");

            pst.executeUpdate();
            System.out.println("Favorite removed succesfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateFavorite() {
        try  {
            String upFavQuery = "UPDATE favorites SET mov_sta_id = ?;";
            PreparedStatement pst = c.prepareStatement(upFavQuery);

            pst.setString(1,"1"); // mov_sta_id

            pst.executeUpdate();
            System.out.println("updated succesfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login() {
        try  {
            String loginQuery = "INSERT INTO session VALUES (?);";
            PreparedStatement pst = c.prepareStatement(loginQuery);

            pst.setString(1,"1"); //pro id

            pst.execute();
            System.out.println("login succesfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
