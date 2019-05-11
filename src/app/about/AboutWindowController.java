package app.about;

import app.VersionInfo;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutWindowController implements Initializable
{
    @FXML private ImageView appIcon;
    @FXML private TextArea aboutBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        animateFadeIn(appIcon, 1.0);
        animateFadeIn(aboutBox, 0.5);
        aboutBox.setEditable(false);
        aboutBox.setText(infoText());
    }

    private String infoText()
    {
        StringBuilder info = new StringBuilder();
        VersionInfo versionInfo =  new VersionInfo();
        info.append("Product Version" + "\n")
                .append(versionInfo.getName())
                .append(" ")
                .append(versionInfo.getVersion())
                .append("\n\n");
        info.append("Build Information" + "\n" + "Version: ")
                .append(versionInfo.getVersion())
                .append("\n").append("Date: ")
                .append(versionInfo.getBuildDate())
                .append("\n\n");
        info.append("Java" + "\n")
                .append(System.getProperty("java.runtime.version"))
                .append(", ")
                .append(System.getProperty("java.vendor"))
                .append("\n\n");
        info.append("Operating System" + "\n")
                .append(System.getProperty("os.name"))
                .append(", ").append(System.getProperty("os.arch"))
                .append(", ")
                .append(System.getProperty("os.version"))
                .append("\n\n");
        info.append("Email")
                .append("\n")
                .append("rizwan.hasan486@gmail.com")
                .append("\n\n");
        info.append("Source code" + "\n")
                .append(versionInfo.getGithubLink())
                .append("\n\n");
        info.append(versionInfo.getCopyright());
        return info.toString();
    }

    private void animateFadeIn(Node node, double sec)
    {
        FadeTransition fadeIn = new FadeTransition();
        fadeIn.setDuration(Duration.seconds(sec));
        fadeIn.setNode(node);
        fadeIn.setFromValue(0.1);
        fadeIn.setToValue(1.0);
        fadeIn.setCycleCount(1);
        fadeIn.setAutoReverse(false);
        fadeIn.playFromStart();
    }
}
