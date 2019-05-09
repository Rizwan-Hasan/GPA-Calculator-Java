package app.about;

import app.resources;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AboutWindow
{
    public void showWindow ()
    {
        try {
            // Window Opening
            FXMLLoader aboutWindowFXML = new FXMLLoader(getClass().getResource("AboutWindow.fxml"));
            Parent root = aboutWindowFXML.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("AboutWindow.css").toExternalForm());
            stage.setTitle("About");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.getIcons().add(new resources().aboutIcon);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
