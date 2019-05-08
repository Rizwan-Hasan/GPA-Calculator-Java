package app.gsheetedit;

import app.Main;
import app.gradeList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.File;
import java.util.Scanner;

public class GradeSheetEditor
{
    public void showWindow ()
    {
        try {
            // Window Opening
            FXMLLoader gradeSheetFXML = new FXMLLoader(getClass().getResource("gsheetEditor.fxml"));
            Parent root = gradeSheetFXML.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            if (new Main().isWindows())
                scene.getStylesheets().add(getClass().getResource("gsheetEditor.css").toExternalForm());
            stage.setTitle("Grade Sheet Editor");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.getIcons().add(new Main().icon);
            stage.show();

            // Warning
            showEditSheetWarning(stage);

            // Controller
            GSheetEditorController controller = gradeSheetFXML.getController();

            // Loading Grade Sheet File's text in TextArea
            controller.gradeTextBox.setText(getGradeSheetFileText());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getGradeSheetFileText()
    {
        try {
            return new Scanner (
                    new File(new gradeList().gradeSheetFileName)
            ).useDelimiter("\\A").next().strip();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void showEditSheetWarning(Stage stage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Editing Tips");
        alert.setHeaderText("To edit grade sheet, you have to follow the default pattern.\n" +
                            "Otherwise it won't work.");
        alert.setContentText("Click Ok to continue");
        alert.initOwner(stage);
        alert.show();
    }
}
