package app.gsheetedit;

import app.Main;
import app.gradeList;
import app.resources;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
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
            stage.getIcons().add(new resources().editIcon);
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
        alert.setTitle("Tips");
        alert.setHeaderText(null);
        alert.setContentText("Make sire you have followed default pattern. Otherwise it will generate error.");
        alert.getDialogPane().setGraphic(new ImageView(new resources().tipsIcon));
        alert.initOwner(stage);
        alert.show();
    }
}
