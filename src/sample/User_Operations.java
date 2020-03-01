package sample;

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
    public void addFavorite() {
        try  {
            String addFavQuery = "INSERT INTO favorites VALUES (?,?,?);";
            PreparedStatement pst = c.prepareStatement(addFavQuery);

            pst.setString(1,"1"); // pro_id
            pst.setString(2, "dummy"); //mov_sta_id
            pst.setString(3, "100"); //mov_id

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



}
