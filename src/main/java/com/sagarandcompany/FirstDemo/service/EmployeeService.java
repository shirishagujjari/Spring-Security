package com.sagarandcompany.FirstDemo.service;

import com.sagarandcompany.FirstDemo.domain.Employee;
import com.sagarandcompany.FirstDemo.repository.EmployeeRepository;
import com.sagarandcompany.FirstDemo.util.ResponseDTO;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @PersistenceContext
    EntityManager entityManager;

    public Employee save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.getTransaction().begin();
        Employee dbEmp = session.find(Employee.class, employee.getId());
        dbEmp.setName(employee.getName());
        dbEmp.setEmail(employee.getName());
        dbEmp.setSalary(6578);
        session.update(dbEmp);
        session.flush();

        //detaached object
        dbEmp.setEmail("Sagar@gmail.com");
        session.merge(dbEmp);
        session.getTransaction().commit();
        return employee;
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
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.find(Employee.class, id);
//        Employee empp = new Employee();
//        BeanUtils.copyProperties(employee, empp);
        return employee;
    }

}
