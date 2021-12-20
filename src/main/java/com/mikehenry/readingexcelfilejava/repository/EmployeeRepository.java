package com.mikehenry.readingexcelfilejava.repository;

import com.mikehenry.readingexcelfilejava.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
