package app.license;

import app.resources;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LicenseWindow
{
    public void showWindow ()
    {
        try {
            // Window Opening
            FXMLLoader licenseWindowFXML = new FXMLLoader(getClass().getResource("LicenseWindow.fxml"));
            Parent root = licenseWindowFXML.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("LicenseWindow.css").toExternalForm());
            stage.setTitle("License");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.getIcons().add(new resources().mitIcon);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
