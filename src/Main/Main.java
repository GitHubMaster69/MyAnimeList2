package Main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {



    public static void main(String[] args) {
	// write your code here
        SqliteDB db = new SqliteDB();
        Operations op = new Operations();
        User_Operations uop = new User_Operations();




       // op.createMovie();
       // op.removeMovie();
        //op.avgReview();
        //db.listProfiles();
        //op.updatePictures();
        //op.readPicture();
        //uop.login();
        uop.review();

        db.closeConnection();
        /*
        Sorting of movies
        List<String> names = Arrays.asList("Alex", "Charles", "Brian");
        Collections.sort(names);
        Collections.sort(names, Collections.reverseOrder());
        System.out.println((names).toString());
        */
    }
















}
