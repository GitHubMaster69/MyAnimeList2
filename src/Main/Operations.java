package Main;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Operations extends SqliteDB {

    public void listProfiles() {
        try {
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM profiles");

            while (rs.next()) {
                int id = rs.getInt("pro_id");
                String firstname = rs.getString("pro_fname");
                String lastname = rs.getString("pro_lname");
                int age = rs.getInt("pro_age");


                System.out.println(id + "" + firstname + "" + lastname + "" + age);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void avgReview() {
        try {
            String avgQuery = "SELECT avg(rev_stars) AS avg FROM rating WHERE mov_id = ?;";
            PreparedStatement pst = c.prepareStatement(avgQuery);
            pst.setString(1, "1");
            ResultSet rs = pst.executeQuery();

            Integer avg = rs.getInt("avg");

            pst.execute();
            System.out.println("Average created succesfully");
            System.out.println(avg);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1; ) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        return bos != null ? bos.toByteArray() : null;
    }
/*
    private void readPicture(int materialId, String filename) {
        FileOutputStream fos = null;
        ResultSet rs = null;

        try {
            String upPicQuery = "SELECT picture FROM movie WHERE mov_id = ?;";
            PreparedStatement pst = c.prepareStatement(upPicQuery);

            File file = new File(filename);
            fos = new FileOutputStream(file);

            System.out.println("Writing BLOB to file " + file.getAbsolutePath());
            while (rs.next()) {
                InputStream input = rs.getBinaryStream("picture");
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    fos.write(buffer);
                }
            }
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
                if (fos != null) {
                    fos.close();
                }

            } catch (SQLException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
*/

    public void updatePictures() {

        try  {
            String upPicQuery = "UPDATE movie SET mov_picture = ? WHERE mov_id = ?;";
            PreparedStatement pst = c.prepareStatement(upPicQuery);

            pst.setBytes(1,readFile("C:\\Users\\bobo1\\Downloads\\para.jpg")); // mov_picture
            pst.setString(2, "5"); //mov_id

            pst.executeUpdate();
            System.out.println("Picture added succesfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
