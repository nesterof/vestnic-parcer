package view;

import controller.XLTController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;

public class FXMLExampleController {

    @FXML
    private Text input_file_name;

    @FXML
    private Text output_file_name;

    private static final String DEFAULT_LABEL_VALUE = ".......";
    @FXML
    private ComboBox<String> transformationList;

    @FXML
    protected void uploadImportFile(ActionEvent event) {

        final FileChooser fileChooser = createXMLFileChooser("Выберете XML для импорта");

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            input_file_name.setText(file.getPath());
        }

    }

    private FileChooser createXMLFileChooser(String title) {
        final FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle(title);
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        return fileChooser;
    }

    @FXML
    protected void uploadExportFile(ActionEvent event) {

        final FileChooser fileChooser = createXMLFileChooser("Выберете XML имя преобразованного файла");

        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            output_file_name.setText(file.getPath());
        }
    }

    @FXML
    protected void transformFile(ActionEvent event) {
        try {
            checkFileName();

            XLTController.getInstance().parceXLT(input_file_name.getText(), output_file_name.getText(), transformationList.getSelectionModel().getSelectedItem() == null ?
                    transformationList.getPromptText() : transformationList.getSelectionModel().getSelectedItem() );

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Преобразованный файл успешно создан" +"\n" + output_file_name.getText());
        alert.showAndWait();
    }

    private boolean checkFileName() throws Exception {
        if(input_file_name.getText() == null || input_file_name.getText().equals(DEFAULT_LABEL_VALUE)) {
            throw new Exception("Не выбранно имя входного файла");
        }
        if(output_file_name.getText() == null || output_file_name.getText().equals(DEFAULT_LABEL_VALUE)) {
            throw new Exception("Не выбранно имя выходного файла");
        }

        return false;
    }
}
