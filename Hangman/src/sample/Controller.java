package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    //Imports objects with ids from fxml
    @FXML
    private GridPane menuScene;
    @FXML
    private ComboBox<String> menuPack;
    @FXML
    private ComboBox<String> menuLanguage;

    @FXML
    private GridPane chooseWordScene;
    @FXML
    private TextField chooseWordInput;

    @FXML
    private GridPane guessScene;
    @FXML
    private ImageView guessImage;
    @FXML
    private Text guessWord;
    @FXML
    private Text guessLetters;
    @FXML
    private TextField guessInput;

    @FXML
    private GridPane winScene;

    @FXML
    private GridPane loseScene;


    private String wordToGuess = "";


    /**
     * Initializes the scene and sets up everything
     */
    public void initialize() {
        //Hide all scenes other than menu scene
        chooseWordScene.setVisible(false);
        guessScene.setVisible(false);
        winScene.setVisible(false);
        loseScene.setVisible(false);

        fillComboBoxes();
    }


    /**
     * Adds all languages with language files to the selectable list of languages + option to choose own word
     */
    private void fillComboBoxes() {
        File[] languageFiles = new File("src/sample/languages/").listFiles(); //Gets all languages from which files exist

        //Loop through all language files
        for (File file : languageFiles) {
            menuLanguage.getItems().addAll(file.getName().substring(0, file.getName().length() - 4)); //Add language to selectable list, without filesystem position and extension name
        }

        menuLanguage.getItems().addAll("Choose word"); //Add option for user to choose own word

        menuLanguage.setValue(menuLanguage.getItems().get(0));


        ArrayList<File> packs = TexturePack.getPacks(); //Gets all packs from which folders exist

        //Loop through all packs
        for (File pack : packs) {
            System.out.println(pack);
            menuPack.getItems().addAll(pack.getName());
        }
        menuPack.setValue(packs.get(0).getName());
    }

    /**
     * Goes to next scene when submit button in main menu is pressed
     *
     * @throws IOException
     */
    public void menuSubmitPressed() throws IOException {
        if (menuLanguage.getValue() == null) return; //Return if no language is selected

        if (menuLanguage.getValue().equals("Choose word")) { //Check if user chose to enter own word
            //Change active scene
            menuScene.setVisible(false);
            chooseWordScene.setVisible(true);
        } else {
            wordToGuess = Language.getRandomWord(menuLanguage.getValue() + ".txt"); //Get a random word from the language file selected

            setupGuessScene();

            //Change active scene
            menuScene.setVisible(false);
            guessScene.setVisible(true);

        }
    }

    /**
     * Move to guessing scene when word is chosen
     */
    public void chooseWordSubmitPressed() {
        String input = chooseWordInput.getText(); //Get chosen word from input box

        if (input == null) return; //Check that text field is not empty
        wordToGuess = input;
        setupGuessScene();

        //Change active scene
        chooseWordScene.setVisible(false);
        guessScene.setVisible(true);
    }


    /**
     * Sets up scene for guessing
     */
    private void setupGuessScene() {
        Backend.initialSetup(wordToGuess);
        guessWord.setText(Backend.getUnderscoreString());
        guessLetters.setText("Guessed Letters: ");
    }

    /**
     * Handles input from guessing scene, checks if guess was correct and changes fields accordingly
     *
     * @throws FileNotFoundException
     */
    public void guessSubmitPressed() throws FileNotFoundException {

        String input = guessInput.getText(); //Gets input from text field

        //Skip guess if no input was given
        if (input.isEmpty()) {
            System.out.println("input was null");
            return;
        }

        Backend.makeGuess(guessInput.getText().charAt(0));

        //Update GUI
        guessWord.setText(Backend.getUnderscoreString());
        guessLetters.setText("Guessed Letters: " + Backend.getGuessedLetters());

        guessInput.setText(""); //Clear guess field

        //Update man being hung
        Image image = new Image(new FileInputStream("src/sample/images/default/hang11.png"));
        guessImage.setImage(image);

        if (Backend.win) {
            win();
        }
        if (Backend.lose) {
            lose();
        }
    }

    private void win() {
        guessScene.setVisible(false);
        winScene.setVisible(true);
    }

    private void lose() {
        guessScene.setVisible(false);
        loseScene.setVisible(true);
    }

    /**
     * Handle button to return to main menu, changing active scenes
     */
    public void mainMenuPressed() {
        winScene.setVisible(false);
        loseScene.setVisible(false);
        menuScene.setVisible(true);
    }

    public void packSelected() {

        TexturePack.selectPack(menuPack.getValue());
    }
}
