package com.employeemanagement.services;

import java.util.List;

import com.employeemanagement.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);

    List<Employee> findAllEmployeeByNameAsc();

    List<Employee> findAllEmployeeByNameDesc();

    List<Employee> findAllEmployeeByAgeDesc();

    List<Employee> findAllEmployeeByAgeAsc();

    List<Employee> findEmployeeByKeyword(String keyword);
}