package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

public class Controller {
    public void handleSubmitButtonAction(ActionEvent actionEvent) throws IOException {
        System.out.println(languageSelect.getValue());

        if (languageSelect.getValue() == "Choose Word") {
            System.out.println("Nice, maybe someday you can actually choose a word");
        } else {
            System.out.println("The word is: "+ Language.getRandomWord(languageSelect.getValue().toString()+ ".txt"));
            //wordText.setValue("wow");
        }
    }

    @FXML
    private ComboBox languageSelect;
    

    public void initialize() {
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
