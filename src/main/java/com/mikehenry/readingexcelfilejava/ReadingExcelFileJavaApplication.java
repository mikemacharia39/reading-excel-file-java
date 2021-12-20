package com.mikehenry.readingexcelfilejava;

import com.mikehenry.readingexcelfilejava.model.Employee;
import com.mikehenry.readingexcelfilejava.service.EmployeeService;
import com.mikehenry.readingexcelfilejava.util.EmployeeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class ReadingExcelFileJavaApplication implements CommandLineRunner {

	public final EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(ReadingExcelFileJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String path = "static/SampleDataEmployee.xlsx";

		EmployeeUtils employeeUtils = new EmployeeUtils();

		List<Employee> employeeList = employeeUtils.extractDataFromExcel(path);

		log.info("Employee Data Loaded from File");
		employeeList.forEach(employee -> log.info(employee.getFirstName() + "\t" + employee.getLastName()
				+ "\t" + employee.getEmailAddress() + "\t" + employee.getActive()));

		log.info("Saving employee data");
		employeeService.saveEmployeeList(employeeList);
	}
}
