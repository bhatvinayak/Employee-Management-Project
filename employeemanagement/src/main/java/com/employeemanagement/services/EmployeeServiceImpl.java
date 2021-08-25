package com.employeemanagement.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.model.Employee;
import com.employeemanagement.repository.DepartmentRepository;
import com.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public EmployeeServiceImpl() {
    }

    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = this.employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = (Employee)optional.get();
            return employee;
        } else {
            throw new RuntimeException("Employee not found for id :: " + id);
        }
    }

    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }

    public List<Employee> findAllEmployeeByNameAsc() {
        return this.employeeRepository.findAllEmployeeByNameAsc();
    }

    public List<Employee> findAllEmployeeByNameDesc() {
        return this.employeeRepository.findAllEmployeeByNameDesc();
    }

    public List<Employee> findAllEmployeeByAgeDesc() {
        return this.employeeRepository.findAllEmployeeByAgeDesc();
    }

    public List<Employee> findAllEmployeeByAgeAsc() {
        return this.employeeRepository.findAllEmployeeByAgeAsc();
    }

    public List<Employee> findEmployeeByKeyword(String keyword) {
        return this.employeeRepository.findEmployeeByKeyword(keyword);
    }
}
