package com.sagarandcompany.FirstDemo.repository;

import com.sagarandcompany.FirstDemo.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
