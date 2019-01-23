package kudrya.design.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import kudrya.CONSTANTS;
import kudrya.core.FileReaderStudents;
import kudrya.core.Student;
import kudrya.core.writer.FileWriter;
import kudrya.design.Message;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AddController {

    final static Logger logger = Logger.getLogger(AddController.class);

    public TextField textFieldName;
    public TextField textFieldSurname;
    public TextField textFieldBirthday;
    public TextField textFieldPhone;
    public TextField textFieldAddress;
    public TextField textFieldCourse;
    public TextField textFieldGroup;
    public TextField textFieldFacultet;

    boolean check(String name, String text) {
        boolean res = text.isEmpty();
        if (res) {
            logger.error("Empty field " + name);
            new Message("Error in adding student", "Empty field", "Please add info " + name).show();
        }
        return !res;
    }

    public void clickAdd(ActionEvent actionEvent) {
        boolean status = true;
        String name = textFieldName.getText();
        status = status && check("name", name);
        String surname = textFieldSurname.getText();
        status = status && check("surname", surname);
        String date = textFieldBirthday.getText();
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            status = false;
            logger.error(e);
            new Message("Error in adding student", "Non correct date", "Error parse date").show();
        }
        String phone = textFieldPhone.getText();
        status = status && check("phone", phone);
        String address = textFieldAddress.getText();
        status = status && check("address", address);
        String course = textFieldCourse.getText();
        status = status && check("course", course);
        String group = textFieldGroup.getText();
        status = status && check("group", group);
        String fac = textFieldFacultet.getText();
        status = status && check("faculter", fac);
        if (status) {
            List<Student> buf = new FileReaderStudents(CONSTANTS.DATABASE.name()).get();
            buf.add(new Student(name, surname, birthday, phone, address, course, group, fac));
            new FileWriter(CONSTANTS.DATABASE.name(), buf).write();
        }
    }
}
