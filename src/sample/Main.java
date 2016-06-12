package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Process.PrivateCacheManager;

public class Main extends Application {
    public static PrivateCacheManager manager = PrivateCacheManager.getInstance();

    @Override
    public void start(Stage stage) throws Exception{
        Parent login = FXMLLoader.load(getClass().getResource("view/LoginView.fxml"));
        //Stage > Scene > Container(Group) > Node 순...
        stage.setTitle("FXML World");
        stage.setScene(new Scene(login, 300, 275));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
