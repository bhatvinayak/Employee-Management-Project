package com.employeemanagement.services;

import java.util.List;

import com.employeemanagement.model.Department;

public interface DepartmentService {
    List<Department> getAllDepartment();

    void saveDepartment(Department department);

    Department getDepartmentById(long id);

    void deleteDepartmentById(long id);

    List<Department> findAllDepartmentByNameDesc();

    List<Department> findAllDepartmentByNameAsc();
}
