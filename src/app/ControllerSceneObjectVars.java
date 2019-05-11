package app;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

class ControllerSceneObjectVars
{
    // Layouts
    @FXML protected AnchorPane mainForm;

    // Labels
    @FXML protected Label mainLabel;

    // Buttons
    @FXML protected Button calculateButton;

    // MenuItems
    @FXML protected MenuItem quitMenuBtn;
    @FXML protected MenuItem editSheetBtn;
    @FXML protected MenuItem licenseMenuBtn;
    @FXML protected MenuItem aboutMenuBtn;

    // TextFields
    @FXML protected TextField theoryBox;
    @FXML protected TextField labBox;

    // CheckBoxes
    @FXML protected CheckBox theoryCheckBox;
    @FXML protected CheckBox labCheckBox;

    // ImageViews
    @FXML protected ImageView circleImage;

}
