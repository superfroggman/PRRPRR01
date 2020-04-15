package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;

public class Controller {

    @FXML
    private GridPane mainMenu;

    @FXML
    private GridPane nextScene;

    @FXML
    private ComboBox languageSelect;

    @FXML
    private Text wordText;


    public void handleSubmitButtonAction(ActionEvent actionEvent) throws IOException {
        System.out.println(languageSelect.getValue());

        if (languageSelect.getValue() == "Choose Word") {
            System.out.println("Nice, maybe someday you can actually choose a word");
        } else {
            String word = Language.getRandomWord(languageSelect.getValue().toString()+ ".txt");
            System.out.println("The word is: "+word);
            wordText.setText(word);

            mainMenu.setVisible(false);
            nextScene.setVisible(true);
        }
    }




    public void initialize() {
        nextScene.setVisible(false);
        fillLanguageSelectBox();
    }


    /**
     * Fills languageSelectBox
     */
    public void fillLanguageSelectBox() {
        File[] languageFiles = new File("src/sample/languages/").listFiles();
        for (int i = 0; i < languageFiles.length; i++) {
            languageSelect.getItems().addAll(languageFiles[i].getName().substring(0, languageFiles[i].getName().length() - 4));
        }

        languageSelect.getItems().addAll("Choose word");
    }

}
