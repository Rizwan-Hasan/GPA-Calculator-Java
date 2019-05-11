package app;

import javafx.scene.image.Image;

public class resources
{
    Image icon = new Image (
            getClass().getResource("resources/icon.png").toExternalForm()
    );

    Image questionIcon = new Image (
            getClass().getResource("resources/question.png").toExternalForm()
    );

    public Image tipsIcon = new Image (
            getClass().getResource("resources/tips.png").toExternalForm()
    );

    public Image aboutIcon = new Image (
            getClass().getResource("resources/about.png").toExternalForm()
    );

    public Image mitIcon = new Image (
            getClass().getResource("resources/MIT.png").toExternalForm()
    );

    public Image editIcon = new Image (
            getClass().getResource("resources/edit.png").toExternalForm()
    );
}
