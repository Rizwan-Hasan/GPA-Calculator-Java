package app.license;

import app.ExtraWork;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.io.File;
import java.util.Scanner;
import java.net.URL;
import java.util.ResourceBundle;

public class LicenseWindowController implements Initializable
{
    @FXML private TextArea licenseBox;
    @FXML private ImageView licenseLogo;
    @FXML private ImageView opensourceLogo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.setLicenseText();
        this.animateFadeIn(licenseLogo, 1.3);
        this.animateFadeIn(opensourceLogo, 1.0);
        this.animateFadeIn(licenseBox, 0.5);
    }

    private void setLicenseText()
    {
        try {
            String licenseFile = new ExtraWork().appRootPath() + "LICENSE";
            String licenseText = new Scanner(new File(licenseFile)).useDelimiter("\\A").next().strip();
            licenseBox.setEditable(false);
            licenseBox.setText(licenseText);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
