package kudrya.core.writer;

import kudrya.core.Student;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileWriter implements Writer {
    private String path;
    private List<Student> students;

    public FileWriter(String path, List<Student> students) {
        this.path = path;
        this.students = students;
    }


    public void write() {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(students);
            objectOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
