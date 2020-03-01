package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent login = FXMLLoader.load(getClass().getResource("resources/login.fxml"));
        Parent Menu = FXMLLoader.load(getClass().getResource("resources/Menu.fxml"));


        primaryStage.setTitle("FilmDatabase");
        primaryStage.setScene(new Scene(login, 600, 400));
        primaryStage.show();

        // write your code here
        SqliteDB db = new SqliteDB();
        Operations op = new Operations();



        // op.createMovie();
        // op.removeMovie();
        //op.avgReview();


       // db.listProfiles();

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
