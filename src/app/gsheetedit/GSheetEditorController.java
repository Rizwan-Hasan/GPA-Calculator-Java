package app.gsheetedit;

import app.gradeList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

public class GSheetEditorController implements Initializable {

    // Buttons
    @FXML protected Button closeBtn;
    @FXML protected Button saveBtn;

    // TextAreas
    @FXML protected TextArea gradeTextBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Nothing Here
    }

    @FXML
    public void closeBtnAction(ActionEvent event)
    {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void saveBtnAction(ActionEvent event)
    {
        Map<String, Object> data = new HashMap<>();
        String[] lines = gradeTextBox.getText().split("\n");
        for (String line : lines) {
            String[] tmp = line.split(":");
            String key = tmp[0].strip();
            double value = Double.valueOf(tmp[1].strip());
            data.put(key, value);
        }

        boolean status = new gradeList().dump(data);

        if (status) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successful");
            alert.setHeaderText("Grade Sheet has been updated successfully");
            alert.setContentText("Click Ok to continue");
            alert.initOwner(saveBtn.getScene().getWindow());
            Optional<ButtonType> alertStatus = alert.showAndWait();
            if (alertStatus.isPresent() && alertStatus.get() == ButtonType.OK)
                closeBtn.fire();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Can not update Grade Sheet");
            alert.setContentText("Click Ok to continue");
            alert.show();
        }
    }
}
