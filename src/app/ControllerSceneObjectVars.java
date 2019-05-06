package app;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

class ControllerSceneObjectVars
{
    //Layouts
    @FXML protected AnchorPane mainForm;

    // Labels
    @FXML protected Label mainLabel;

    // Buttons
    @FXML protected Button calculateButton;
    @FXML protected MenuItem quitMenuBtn;

    // TextFields
    @FXML protected TextField theoryBox;
    @FXML protected TextField labBox;

    //CheckBoxes
    @FXML protected CheckBox theoryCheckBox;
    @FXML protected CheckBox labCheckBox;

    //ImageViews
    @FXML protected ImageView circleImage;
}
