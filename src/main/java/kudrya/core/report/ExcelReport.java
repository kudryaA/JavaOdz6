package kudrya.core.report;

import kudrya.core.Student;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelReport implements Report {

    private String path;
    private List<Student> list;

    public ExcelReport(String path, List<Student> list) {
        this.path = path;
        this.list = list;
    }

    @Override
    public void save() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Result");
        int rowNum = 0;
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Name");
        row.createCell(1).setCellValue("Surname");
        row.createCell(2).setCellValue("Birthday");
        row.createCell(3).setCellValue("Phone");
        row.createCell(4).setCellValue("Address");
        row.createCell(5).setCellValue("Course");
        row.createCell(6).setCellValue("Group");
        row.createCell(7).setCellValue("Facultet");
        for (Student dataModel : list) {
            createSheetHeader(sheet, ++rowNum, dataModel);
        }

        try (FileOutputStream out = new FileOutputStream(new File(path))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createSheetHeader(HSSFSheet sheet, int rowNum, Student student) {
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue(student.getName());
        row.createCell(1).setCellValue(student.getSurname());
        row.createCell(2).setCellValue(student.getBirthday().toString());
        row.createCell(3).setCellValue(student.getPhone());
        row.createCell(4).setCellValue(student.getAddress());
        row.createCell(5).setCellValue(student.getCourse());
        row.createCell(6).setCellValue(student.getGroup());
        row.createCell(7).setCellValue(student.getFacultet());
    }
}
