package kudrya.core.filters;

import kudrya.core.ReaderStudents;
import kudrya.core.Student;

import java.util.List;
import java.util.stream.Collectors;

public class ReaderFacultetStudents implements ReaderStudents {
    private ReaderStudents readerStudents;
    private String facultet;

    public ReaderFacultetStudents(ReaderStudents readerStudents, String facultet) {
        this.readerStudents = readerStudents;
        this.facultet = facultet;
    }


    @Override
    public List<Student> get() {
        return readerStudents.get().stream().filter(item -> item.getFacultet().equals(facultet)).collect(Collectors.toList());
    }
}
