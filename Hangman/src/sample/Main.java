package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private HBox introHBox = new HBox();
    private HBox guessHBox = new HBox();
    private Scene introScene;
    private Scene guessScene;

    private int windowWidth = 1280;
    private int windowHeight = 720;

    @Override
    public void start(Stage primaryStage) throws Exception{

        //introScene = new Scene(introHBox, 1280,720);

        primaryStage.setTitle("Hangman!");
        setupIntroScene(primaryStage);
        primaryStage.show();



    }


    public void setupIntroScene(Stage primaryStage){

        introHBox.setBackground(new Background(new BackgroundFill(Color.rgb(51,54,61), CornerRadii.EMPTY, Insets.EMPTY)));
        introScene = new Scene(introHBox, windowWidth, windowHeight);
        primaryStage.setScene(introScene);


        Button button1 = new Button("Cool Button");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setupGuessScene(primaryStage);
            }
        });

        introHBox.getChildren().add(button1);
    }


    public void setupGuessScene(Stage primaryStage){

        guessHBox.setBackground(new Background(new BackgroundFill(Color.rgb(0,54,61), CornerRadii.EMPTY, Insets.EMPTY)));
        guessScene = new Scene(guessHBox, windowWidth, windowHeight);
        primaryStage.setScene(guessScene);

        guessScene.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println("Key Pressed: " + keyEvent.getCharacter());
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
