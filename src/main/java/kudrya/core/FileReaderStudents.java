package kudrya.core;

import kudrya.core.writer.FileWriter;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderStudents implements ReaderStudents {

    final static Logger logger = Logger.getLogger(FileReaderStudents.class);

    private String path;

    public FileReaderStudents(String path) {
        this.path = path;
    }

    @Override
    public List<Student> get() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            logger.error("Error in reading object to" + path);
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ObjectInputStream objectInputStream = null;
        List<Student> res = new ArrayList<Student>();
        try {
            objectInputStream = new ObjectInputStream(bufferedInputStream);
            res = (List<Student>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            logger.error("Error in getting object from" + path);
        } catch (ClassNotFoundException e) {
        }
        return res;
    }
}
