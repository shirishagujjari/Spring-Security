package com.sagarandcompany.FirstDemo.service;

import com.sagarandcompany.FirstDemo.domain.Employee;
import com.sagarandcompany.FirstDemo.repository.EmployeeRepository;
import com.sagarandcompany.FirstDemo.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @PersistenceContext
    EntityManager entityManager;

    public Employee save(Employee employee) {
        ;
        if (employee.getId() != null) {
//            Employee employee1 = employeeRepository.findById(employee.getId()).get();
            Employee employee1 = entityManager.find(Employee.class,employee.getId(), LockModeType.PESSIMISTIC_WRITE);
            employee1.setName(employee.getName());
            employee = employee1;
//            entityManager.lock(employee1, LockModeType.PESSIMISTIC_WRITE);
//            entityManager.lock(employee, LockModeType.PESSIMISTIC_READ);
        }
        return employeeRepository.save(employee);
    }

    public ResponseDTO findByEmail(String email) {
        Optional<Employee> optional = employeeRepository.findByEmail(email);
        ResponseDTO responseDTO = new ResponseDTO();
        if (optional.isPresent()) {
            responseDTO.setData(optional.get());
            return responseDTO;
        }
        responseDTO.setMessage("Record is not found");
        responseDTO.setStatus(false);
        return responseDTO;
    }

    public Employee get(Long id) {
        employeeRepository.findById(id).get();
        employeeRepository.findById(id).get();
        employeeRepository.findById(id).get();
        employeeRepository.findById(id).get();
        employeeRepository.findById(id).get();
        employeeRepository.findById(id).get();
        return employeeRepository.findById(id).get();
    }

}
