package app;

import app.about.AboutWindow;
import app.gsheetedit.GradeSheetEditor;
import app.license.LicenseWindow;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
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
        alert.setContentText(null);

        alert.getDialogPane().setGraphic(new ImageView(new resources().questionIcon));

        alert.initOwner(calculateButton.getScene().getWindow());
        ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(yesButton, noButton);
        Optional<ButtonType> alertStatus = alert.showAndWait();
        if (alertStatus.isPresent() && alertStatus.get() == yesButton) {
            System.out.println("Quit");
            Platform.exit();
        }
        event.consume();
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
        event.consume();
    }

    @FXML
    public void editSheetBtnAction (ActionEvent event)
    {
        GradeSheetEditor x = new GradeSheetEditor();
        x.showWindow();
        event.consume();
    }

    @FXML
    public void licenseMenuBtnAction (ActionEvent event)
    {
        LicenseWindow licenseWindow = new LicenseWindow();
        licenseWindow.showWindow();
        event.consume();
    }

    @FXML
    public void aboutMenuBtnAction (ActionEvent event)
    {
        AboutWindow aboutWindow = new AboutWindow();
        aboutWindow.showWindow();
        event.consume();
    }
}
