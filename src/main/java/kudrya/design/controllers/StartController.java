package kudrya.design.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kudrya.CONSTANTS;
import kudrya.Main;
import kudrya.core.FileReaderStudents;
import kudrya.core.ReaderStudents;
import kudrya.core.Student;
import kudrya.core.filters.ReaderCourseStudents;
import kudrya.core.filters.ReaderDateStudents;
import kudrya.core.filters.ReaderFacultetStudents;
import kudrya.core.filters.ReaderGroupStudents;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    @FXML
    private TableView table;
    @FXML
    private TableColumn<Student, String> columnName;
    @FXML
    private TableColumn<Student, String>  columnSurname;
    @FXML
    private TableColumn<Student, Date>  columnBirthday;
    @FXML
    private TableColumn<Student, String>  columnPhone;
    @FXML
    private TableColumn<Student, String>  columnAddress;
    @FXML
    private TableColumn<Student, String>  columnCourse;
    @FXML
    private TableColumn<Student, String>  columnGroup;
    @FXML
    private TableColumn<Student, String>  columnFacultet;

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
        String text = textSearch.getText();
        if (text.contains("clean")) {
            readerStudents = new FileReaderStudents(CONSTANTS.DATABASE.name());
        }
        String[] commands = text.split(";");
        for (String command: commands) {
            String[] buf = command.split(":");
            switch (buf[0]) {
                case "group": readerStudents = new ReaderGroupStudents(readerStudents, buf[1]); break;
                case "course": readerStudents = new ReaderCourseStudents(readerStudents, buf[1]); break;
                case "facultet": readerStudents = new ReaderFacultetStudents(readerStudents, buf[1]); break;
                case "date": readerStudents = new ReaderDateStudents(readerStudents, buf[1]); break;
            }
        }
        show();
    }

    public void clickExcel(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        readerStudents = new FileReaderStudents(CONSTANTS.DATABASE.name());
        columnName.setCellValueFactory(new PropertyValueFactory("name"));
        columnSurname.setCellValueFactory(new PropertyValueFactory("surname"));
        columnBirthday.setCellValueFactory(new PropertyValueFactory("birthday"));
        columnPhone.setCellValueFactory(new PropertyValueFactory("phone"));
        columnAddress.setCellValueFactory(new PropertyValueFactory("address"));
        columnCourse.setCellValueFactory(new PropertyValueFactory("course"));
        columnGroup.setCellValueFactory(new PropertyValueFactory("group"));
        columnFacultet.setCellValueFactory(new PropertyValueFactory("facultet"));
        show();
    }

    private void show() {
        table.setItems(FXCollections.observableArrayList(readerStudents.get()));
    }
}
