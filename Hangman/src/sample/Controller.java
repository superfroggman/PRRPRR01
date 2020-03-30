package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class Controller {
    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        System.out.println("HAHAWOW");

    }

    @FXML
    private ComboBox res;


    public void initialize() {
        res.getItems().addAll("800x600", "1024x768", "1280x720");
    }
}
