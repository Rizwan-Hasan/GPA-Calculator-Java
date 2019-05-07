package app;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.util.Duration;

public class Controller extends ControllerAnimation
{
    @FXML
    public void quitMenuBtnAction (ActionEvent event)
    {
        System.out.println("Quitting");
        System.exit(0);
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
