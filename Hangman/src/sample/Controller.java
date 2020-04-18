package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;

public class Controller {

    //Imports objects with ids from fxml
    @FXML
    private GridPane menuScene;
    @FXML
    private ComboBox languageSelect;


    @FXML
    private GridPane chooseWordScene;
    @FXML
    private TextField chooseWordInput;

    @FXML
    private GridPane guessScene;
    @FXML
    private Text guessWord;
    @FXML
    private TextField guessInput;


    private String wordToGuess = "";

    private int wrongGuesses = 0;


    /**
     * Initializes the scene and sets up everything
     */
    public void initialize() {
        chooseWordScene.setVisible(false);
        guessScene.setVisible(false);

        fillLanguageSelectBox();
    }

    /**
     * Adds all languages with language files to the selectable list of languages + option to choose own word
     */
    public void fillLanguageSelectBox() {
        File[] languageFiles = new File("src/sample/languages/").listFiles(); //Gets all languages from which files exist

        //Loop through all language files
        for (int i = 0; i < languageFiles.length; i++) {
            languageSelect.getItems().addAll(languageFiles[i].getName().substring(0, languageFiles[i].getName().length() - 4)); //Add language to selectable list, without filesystem position and extension name
        }

        languageSelect.getItems().addAll("Choose word");
    }

    /**
     * Goes to next scene when submit button in main menu is pressed
     *
     * @param actionEvent
     * @throws IOException
     */
    public void menuSubmitPressed(ActionEvent actionEvent) throws IOException {
        System.out.println(languageSelect.getValue());

        if (languageSelect.getValue() == null) return;

        if (languageSelect.getValue().equals("Choose word")) {
            menuScene.setVisible(false);
            chooseWordScene.setVisible(true);
        } else {
            wordToGuess = Language.getRandomWord(languageSelect.getValue().toString() + ".txt"); //Get a random word from the language file selected
            System.out.println("The word is: " + wordToGuess);

            //Change active scene
            menuScene.setVisible(false);
            guessScene.setVisible(true);
            setupGuessScene();
        }
    }

    /**
     * Move to guessing scene when word is chosen
     *
     * @param actionEvent
     */
    public void chooseWordSubmitPressed(ActionEvent actionEvent) {
        String input = chooseWordInput.getText(); //Get chosen word from input box
        System.out.println(input);

        if (input == null) return; //Check that text field is not empty
        wordToGuess = input;
        setupGuessScene();

        //Change active scene
        chooseWordScene.setVisible(false);
        guessScene.setVisible(true);
    }


    public void setupGuessScene() {
        guessWord.setText(wordToGuess);
        NewBackend.initialSetup(wordToGuess);
    }

    public void guessSubmitPressed(ActionEvent actionEvent) {
        System.out.println(guessInput.getText());
        NewBackend.makeGuess(guessInput.getText().toCharArray()[0]);

        wrongGuesses = NewBackend.wrongGuesses;
    }
}
