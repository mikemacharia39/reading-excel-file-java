package com.mikehenry.readingexcelfilejava.service;

import com.mikehenry.readingexcelfilejava.model.Employee;
import com.mikehenry.readingexcelfilejava.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    /**
     * To save List of employee
     * @param employeeList List<Employee>
     * @return true|false
     */
    public boolean saveEmployeeList(List<Employee> employeeList) {
        employeeRepository.saveAll(employeeList);
        return true;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
