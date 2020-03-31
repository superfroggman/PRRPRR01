package old;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class OldMain extends Application {

    private HBox introHBox = new HBox();
    private HBox guessHBox = new HBox();
    private Scene introScene;
    private Scene guessScene;

    private int windowWidth = 1280;
    private int windowHeight = 720;

    private String correctWord = "Nice Word Eyy";

    @Override
    public void start(Stage primaryStage) throws Exception {

        //introScene = new Scene(introHBox, 1280,720);

        primaryStage.setTitle("Hangman!");
        setupIntroScene(primaryStage);
        primaryStage.show();

    }


    /**
     * @param primaryStage
     */
    public void setupIntroScene(Stage primaryStage) {

        //Setup scene
        introHBox.setBackground(new Background(new BackgroundFill(Color.rgb(51, 54, 61), CornerRadii.EMPTY, Insets.EMPTY)));
        introScene = new Scene(introHBox, windowWidth, windowHeight);
        primaryStage.setScene(introScene);

        //Create button with eventhandler to react when clicked
        Button button1 = new Button("Cool Button");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setupGuessScene(primaryStage);
            }
        });

        //Add button to scene
        introHBox.getChildren().add(button1);
    }


    /**
     * @param primaryStage
     */
    public void setupGuessScene(Stage primaryStage) {

        //Setup scene
        guessHBox.setBackground(new Background(new BackgroundFill(Color.rgb(0, 54, 61), CornerRadii.EMPTY, Insets.EMPTY)));
        guessScene = new Scene(guessHBox, windowWidth, windowHeight);
        primaryStage.setScene(guessScene);

        //Setup keylistener
        guessScene.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println("Key Pressed: " + keyEvent.getCharacter());
                makeGuess(keyEvent.getCharacter());
                System.out.println(getUnderscores(correctWord));
            }
        });
    }

    /**
     * @param guess
     */
    public void makeGuess(String guess) {
        System.out.println("is " + guess + " in " + correctWord + "? maybe.");
    }

    /**
     * @param word
     * @return
     */
    public String getUnderscores(String word) {

        String out = "";

        //Replaces letters with underscores and spaces with more spaces
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != ' ') {
                out += "_ ";
            } else {
                out += "  ";
            }
        }

        return out;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
