package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application
{
    private static Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("app.fxml"));
        Parent root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(Main::handle);
        scene.getStylesheets().clear();
        if (this.isWindows())
            scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("CGPA Calculator");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(getClass().getResource("icon.png").toExternalForm()));
        primaryStage.show();
    }

    private static void handle(KeyEvent event) {
        // Shortcut Handling
        Object keyCode = event.getCode();

        // Calculate Button Shortcut
        if (keyCode == KeyCode.C) {
            System.out.println("Shortcut key C is pressed");
            controller.calculateButton.fire();
            event.consume();
        }

        // Edit Sheet Button Shortcut
        else if (keyCode == KeyCode.G) {
            System.out.println("Shortcut key G is pressed");
            controller.editSheetBtn.fire();
            event.consume();
        }

        // Quit Button Shortcut
        else if (keyCode == KeyCode.Q) {
            System.out.println("Shortcut key Q is pressed");
            controller.quitMenuBtn.fire();
            event.consume();
        }
    }

    public boolean isWindows()
    {
        return System.getProperty("os.name").startsWith("Windows");
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
