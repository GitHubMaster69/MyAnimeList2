package Main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {



    public static void main(String[] args) {
	// write your code here
        SqliteDB db = new SqliteDB();




       // db.createMovie();
       // db.removeMovie();

        db.listProfiles();

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
