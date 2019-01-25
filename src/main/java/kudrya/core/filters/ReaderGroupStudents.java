package kudrya.core.filters;

import kudrya.core.ReaderStudents;
import kudrya.core.Student;

import java.util.List;
import java.util.stream.Collectors;

public class ReaderGroupStudents implements ReaderStudents {
    private ReaderStudents readerStudents;
    private String group;

    public ReaderGroupStudents(ReaderStudents readerStudents, String group) {
        this.readerStudents = readerStudents;
        this.group = group;
    }


    @Override
    public List<Student> get() {
        return readerStudents.get().stream().filter(item -> item.getGroup().equals(group)).collect(Collectors.toList());
    }
}
