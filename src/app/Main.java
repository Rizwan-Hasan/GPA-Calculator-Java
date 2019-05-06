package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root);
        scene.getStylesheets().clear();
        if (this.isWindows())
            scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("CGPA Calculator");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(getClass().getResource("icon.png").toExternalForm()));
        primaryStage.show();
    }

    boolean isWindows()
    {
        return System.getProperty("os.name").startsWith("Windows");
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
