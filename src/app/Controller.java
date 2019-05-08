package app;

import app.gsheetedit.GradeSheetEditor;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Optional;

public class Controller extends ControllerAnimation
{
    @FXML
    public void quitMenuBtnAction (ActionEvent event)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure to quit?");
        alert.setContentText("Click Ok to quit");
        alert.initOwner(calculateButton.getScene().getWindow());
        Optional<ButtonType> alertStatus = alert.showAndWait();
        if (alertStatus.isPresent() && alertStatus.get() == ButtonType.OK) {
            System.out.println("Quit");
            Stage stage = (Stage) calculateButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void calculateBtnAction (ActionEvent event)
    {
        calculator cgpa = new calculator (
                theoryBox.getText().strip(),
                labBox.getText().strip(),
                theoryCheckBox.isSelected(),
                labCheckBox.isSelected()
        );
        String result = String.valueOf(cgpa.getCGPA());
        // System.out.println(result);
        mainLabel.setText("Your cgpa is: " + result);
        // Main Label Fade In
        {
            FadeTransition fadeIn = new FadeTransition();
            fadeIn.setDuration(Duration.seconds(1));
            fadeIn.setNode(mainLabel);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.setCycleCount(1);
            fadeIn.setAutoReverse(false);
            fadeIn.playFromStart();
        }
    }

    @FXML
    public void editSheetBtnAction(ActionEvent event)
    {
        GradeSheetEditor x = new GradeSheetEditor();
        x.showWindow();
    }

}
