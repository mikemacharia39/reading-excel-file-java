package com.mikehenry.readingexcelfilejava.util;

import com.mikehenry.readingexcelfilejava.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class EmployeeUtils {

    public List<Employee> extractDataFromExcel(String path) {
        log.info("Reading data from {}", path);

        List<String> dataList = new ArrayList<>();

        List<Employee> employeeList = new ArrayList<>();

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();



        try(FileInputStream fileInputStream = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {

            log.info("Extracting data");

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Getting number of columns in the Sheet
            int noOfColumns = sheet.getRow(0).getLastCellNum();

            for (Row row : sheet) {
                for (Cell cell : row) {
                    String cellValue = dataFormatter.formatCellValue(cell);
                    dataList.add(cellValue);
                }
            }

            employeeList = createList(dataList, noOfColumns);

        } catch (FileNotFoundException e) {
            log.error("Path {} not found, error {}", path, e.getMessage());
        } catch (IOException e) {
            log.error("IOException error, path {} not found, error {}", path, e.getMessage());
        }

        return employeeList;
    }

    private List<Employee> createList(List<String> excelData, int noOfColumns) {

        List<Employee> employeeList = new ArrayList<>();

        int i = noOfColumns;
        do {
            Employee employee = new Employee();

            employee.setFirstName(excelData.get(i));
            employee.setLastName(excelData.get(i + 1));
            employee.setEmailAddress(excelData.get(i + 2));
            employee.setActive(Integer.parseInt(excelData.get(i + 3)));
            employee.setChangeDetails(excelData.get(i + 4));

            employeeList.add(employee);
            i = i + (noOfColumns);

        } while (i < excelData.size());

        return employeeList;
    }
}
