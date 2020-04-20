package main.java.com.learning;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.charset.Charset;

public class TestExcel {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("JAVA");

        Object[][] bookdata = {
                {"Oracle", "Hirani", 37},
                {"Scala", "Hector", 35},
                {"Java", "Zoheb", 39}
        };

        int rowCount = 0;

        for(Object[] aObject : bookdata){
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;

            for (Object field : aObject){
                Cell cell = row.createCell(columnCount++);
                if(field instanceof String){
                    cell.setCellValue((String) field);
                }

                if(field instanceof Integer){
                    cell.setCellValue((Integer)field);
                }
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream("/Users/surasing/Documents/Learning/src/main/resources/JavaBooks.xlsx")) {
            workbook.write(outputStream);
            outputStream.close();
            System.out.println("Java Excel file created");
        }

    }
}

class test1Excel {

    public static void main(String[] args) throws IOException {

        FileOutputStream output = new FileOutputStream("/Users/surasing/Documents/Learning/src/main/resources/Myfile.xls");
        OutputStreamWriter outPutWriter = new OutputStreamWriter(output, Charset.forName("UTF-16"));
        BufferedWriter writer = new BufferedWriter(outPutWriter);

        writer.write("Milan");
        writer.newLine();
        writer.write("Suraj");
        writer.newLine();
        writer.write("Avani");

        //writer.close();
    }
}
