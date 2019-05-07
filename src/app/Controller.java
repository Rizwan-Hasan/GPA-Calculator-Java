package app;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
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
        System.out.println(getClass().getResource("gsheetEditor.fxml"));
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gsheetEditor.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Grade Sheet Editor");
            Scene scene = new Scene(root1);
            scene.getStylesheets().clear();
            if (new Main().isWindows())
                scene.getStylesheets().add(getClass().getResource("gsheetEditor.css").toExternalForm());
            stage.setScene(scene);
            stage.setResizable(false);
            stage.getIcons().add(new Image(getClass().getResource("icon.png").toExternalForm()));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void closeBtnAction(ActionEvent event)
    {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
}
