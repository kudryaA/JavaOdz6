package kudrya.design.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kudrya.CONSTANTS;
import kudrya.Main;
import kudrya.core.FileReaderStudents;
import kudrya.core.ReaderStudents;
import kudrya.core.Student;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    public TableView table;
    private ReaderStudents readerStudents = null;

    public TextField textSearch;

    public void clickAdd(MouseEvent mouseEvent) throws IOException {
        ((Stage)textSearch.getScene().getWindow()).close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Main.class.getResource("/fxml/add.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void clickSearch(MouseEvent mouseEvent) {
    }

    public void clickExcel(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        readerStudents = new FileReaderStudents(CONSTANTS.DATABASE.name());
        show(readerStudents.get());
    }

    private void show(List<Student> list) {

    }
}
