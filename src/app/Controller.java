package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller extends ControllerAnimation
{
    @FXML
    public void ok (ActionEvent event)
    {
        System.out.println("Quitting");
        System.exit(0);
    }


}
