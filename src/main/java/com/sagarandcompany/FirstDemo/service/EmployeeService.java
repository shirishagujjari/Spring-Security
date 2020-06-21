package com.sagarandcompany.FirstDemo.service;

import com.sagarandcompany.FirstDemo.domain.Employee;
import com.sagarandcompany.FirstDemo.repository.EmployeeRepository;
import com.sagarandcompany.FirstDemo.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @PersistenceContext
    EntityManager entityManager;

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
        employeeRepository.findById(id).get();
        employeeRepository.findById(id).get();
        employeeRepository.findById(id).get();
        employeeRepository.findById(id).get();
        employeeRepository.findById(id).get();
        employeeRepository.findById(id).get();
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

    //List to fetch employee as per name
    //select * from employee where name='sagar';
    public List<Employee> criteriaDemo1(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }


    //select * from employee where name='sagar' and salary=1000;
    public List<Employee> criteriaDemo2(String name, Integer salary) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
        criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("salary"), salary)));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    //select email from employee where name='sagar';
    public List<Employee> criteriaDemo3(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root.get("email"));
        criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    //select email,salary from employee where name='sagar';
    public List<Employee> criteriaDemo4(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root root = criteriaQuery.from(Employee.class);
        criteriaQuery.multiselect(root.get("email"), root.get("salary"));
        criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    //with constructor(Binding result in employee object)
    //select email,salary from employee where name='sagar';
    public List<Employee> criteriaDemo5(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root root = criteriaQuery.from(Employee.class);
        criteriaQuery.multiselect(criteriaBuilder.construct(Employee.class, root.get("name"), root.get("salary")));
        criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    //select department_id,count(*) from employee;
    public List<Employee> criteriaDemo6(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root root = criteriaQuery.from(Employee.class);
//        Join department = root.join("department");
        criteriaQuery.multiselect(root.get("department"), criteriaBuilder.count(root));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    //select department_id,count(*) from employee group by department_id having count(*) > 1;
    public List<Employee> criteriaDemo7(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root root = criteriaQuery.from(Employee.class);
        Join department = root.join("department");
        criteriaQuery.multiselect(department.get("id"), criteriaBuilder.count(root));
        criteriaQuery.groupBy(department.get("id"));
        criteriaQuery.having(criteriaBuilder.greaterThan(criteriaBuilder.count(root), 1L));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    //select * from employee order by salary desc
    public List<Employee> criteriaDemo8(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("salary")));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    //select min(salary) from employee
    public List<Employee> criteriaDemo9(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(criteriaBuilder.min(root.get("salary")));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
