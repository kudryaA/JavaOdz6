package kudrya.core.filters;

import kudrya.core.ReaderStudents;
import kudrya.core.Student;

import java.util.List;
import java.util.stream.Collectors;

public class ReaderCourseStudents implements ReaderStudents {
    private ReaderStudents readerStudents;
    private String course;

    public ReaderCourseStudents(ReaderStudents readerStudents, String course) {
        this.readerStudents = readerStudents;
        this.course = course;
    }


    @Override
    public List<Student> get() {
        return readerStudents.get().stream().filter(item -> item.getCourse().equals(course)).collect(Collectors.toList());
    }
}
