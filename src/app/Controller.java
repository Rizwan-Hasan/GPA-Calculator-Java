package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class Controller {

    @FXML
    private Button calculateButton;

    @FXML
    private MenuItem quitMenuBtn;

    @FXML
    public void ok (ActionEvent event) {
        System.out.println("Quitting");
        System.exit(0);
    }

}
