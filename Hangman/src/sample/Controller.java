package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.io.File;
import java.util.Objects;
import java.util.stream.Stream;

public class Controller {
    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        System.out.println(languageSelect.getValue());

    }

    @FXML
    private ComboBox languageSelect;


    public void initialize() {
        System.out.println(getFilesCount(new File("src/sample/languages/")));
        File[] languageFiles = new File("src/sample/languages/").listFiles();
        for (int i = 0; i < languageFiles.length; i++) {
            languageSelect.getItems().addAll(languageFiles[i].getName().substring(0, languageFiles[i].getName().length() - 4));
        }

        languageSelect.getItems().addAll("Choose word");
    }

    private int getFilesCount(File directory) {
        File[] files = directory.listFiles();
        return Objects.isNull(files) ? 1 : Stream.of(files)
                .parallel()
                .reduce(0, (Integer acc, File p) -> acc + getFilesCount(p), (a, b) -> a + b);
    }

}
