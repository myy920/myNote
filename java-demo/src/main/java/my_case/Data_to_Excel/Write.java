package my_case.Data_to_Excel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Write {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("第一页");

        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("我");

        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("爱你");
        row1.createCell(1).setCellValue("亲爱的");

        XSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("朋友");

        FileOutputStream fos = new FileOutputStream(new File("E:\\work2.xlsx"));
        book.write(fos);
        fos.flush();
        fos.close();

    }
}
