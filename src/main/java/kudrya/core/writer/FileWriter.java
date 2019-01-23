package kudrya.core.writer;

import kudrya.core.Student;
import kudrya.design.controllers.AddController;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileWriter implements Writer {
    final static Logger logger = Logger.getLogger(FileWriter.class);
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
            logger.warn("File " + path + " not found");
        }
        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(students);
            objectOut.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error in writing object to" + path);
            logger.error(e);
        }
    }
}
