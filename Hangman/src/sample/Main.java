package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Main extends Application {

    public static Scene defaultScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hangman");
        defaultScene = new Scene(root, 600, 400);
        primaryStage.setScene(defaultScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
