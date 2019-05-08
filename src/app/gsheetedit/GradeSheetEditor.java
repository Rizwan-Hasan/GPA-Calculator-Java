package app.gsheetedit;

import app.Main;
import app.gradeList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
            stage.getIcons().add(new Image(getClass().getResource("../icon.png").toExternalForm()));
            stage.show();

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
}
