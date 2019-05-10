package app.about;

import app.VersionInfo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutWindowController implements Initializable
{
    @FXML private TextArea aboutBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
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
}
