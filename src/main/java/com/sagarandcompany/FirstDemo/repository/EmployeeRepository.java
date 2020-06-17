package com.sagarandcompany.FirstDemo.repository;

import com.sagarandcompany.FirstDemo.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByNameAndEmail(String name, String email);

    Optional<Employee> findByNameOrEmail(String name, String email);

    List<Employee> findBySalaryGreaterThan(Integer salary);

    List<Employee> findBySalaryGreaterThanAndSalaryLessThan(Integer min, Integer max);

    List<Employee> findAllByNameStartingWith(String name);

    @Query(value = "from Employee e where e.name =:name")
    List<Employee> searchWithName(String name);
}
