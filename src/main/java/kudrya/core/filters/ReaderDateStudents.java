package kudrya.core.filters;

import kudrya.core.ReaderStudents;
import kudrya.core.Student;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderDateStudents implements ReaderStudents {
    private ReaderStudents readerStudents;
    private int date;

    public ReaderDateStudents(ReaderStudents readerStudents, String date) {
        this.readerStudents = readerStudents;
        this.date = Integer.parseInt(date);
    }

    @Override
    public List<Student> get() {
        return readerStudents.get().stream().filter(item -> {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(item.getBirthday());
            return calendar.get(Calendar.YEAR) >= date;
        }).collect(Collectors.toList());
    }
}
