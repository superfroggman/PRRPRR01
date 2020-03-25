package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private HBox introScene = new HBox();
    private HBox guessScene = new HBox();

    @Override
    public void start(Stage primaryStage) throws Exception{

        setupIntroScene(primaryStage);


    }

    public void setupIntroScene(Stage primaryStage){

        setSceneColor(introScene, Color.rgb(51,54,61));//set background color

        //Setup stage
        primaryStage.setTitle("Hangman!");
        primaryStage.setScene(new Scene(introScene, 1280,720));
        primaryStage.show();

        Button button1 = new Button("Cool Button");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setupGuessScene(primaryStage);
            }
        });

        introScene.getChildren().add(button1);
    }


    public void setupGuessScene(Stage primaryStage){
        setSceneColor(guessScene, Color.rgb(0,54,61));//set background color

        //Setup stage
        primaryStage.setTitle("Hangman!");
        primaryStage.setScene(new Scene(guessScene, 1280,720));
        primaryStage.show();
    }


    /**
     * Sets color of scene
     * @param scene
     * @param color
     */
    public void setSceneColor(HBox scene, Color color){
        scene.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
