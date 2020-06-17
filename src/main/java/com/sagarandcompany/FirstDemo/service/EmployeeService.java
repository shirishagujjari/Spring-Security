package com.sagarandcompany.FirstDemo.service;

import com.sagarandcompany.FirstDemo.domain.Employee;
import com.sagarandcompany.FirstDemo.repository.EmployeeRepository;
import com.sagarandcompany.FirstDemo.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
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

    public ResponseDTO searchRecordWithNameandEmail(String name, String email) {
        Optional<Employee> optional = employeeRepository.findByNameAndEmail(name, email);
        ResponseDTO responseDTO = new ResponseDTO();
        if (optional.isPresent()) {
            responseDTO.setData(optional.get());
            return responseDTO;
        }
        responseDTO.setMessage("Record is not found");
        responseDTO.setStatus(false);
        return responseDTO;
    }

    public ResponseDTO searchRecordWithNameOrEmail(String name, String email) {
        Optional<Employee> optional = employeeRepository.findByNameOrEmail(name, email);
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
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findBySalaryGreaterThan(Integer salary) {
        List<Employee> employeeList = employeeRepository.findBySalaryGreaterThan(salary);
        return employeeList;
    }

    public List<Employee> findBySalaryGreaterThanAndSalaryLessThan(Integer min, Integer max) {
        List<Employee> employeeList = employeeRepository.findBySalaryGreaterThanAndSalaryLessThan(min, max);
        return employeeList;
    }

    public List<Employee> search4(String name) {
        List<Employee> employeeList = employeeRepository.findAllByNameStartingWith(name);
        return employeeList;

    }
    public List<Employee> search6(String name) {
        List<Employee> employeeList = employeeRepository.searchWithName(name);
        return employeeList;
    }
}
