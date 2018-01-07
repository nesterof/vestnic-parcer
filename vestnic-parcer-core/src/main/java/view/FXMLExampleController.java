package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;

public class FXMLExampleController {

    @FXML
    private Text input_file_name;


    @FXML
    protected void uploadImportFile(ActionEvent event) {

        final FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Выберете XML для импорта");
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            input_file_name.setText(file.getName());
        }

    }

    @FXML
    protected void uploadExportFile(ActionEvent event) {

        final FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Выберете XML для импорта");
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            input_file_name.setText(file.getName());
        }

    }
}
