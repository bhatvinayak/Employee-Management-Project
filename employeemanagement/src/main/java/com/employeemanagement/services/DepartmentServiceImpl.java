package com.employeemanagement.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.model.Department;
import com.employeemanagement.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeService employeeService;

    public DepartmentServiceImpl() {
    }

    public List<Department> getAllDepartment() {
        return this.departmentRepository.findAll();
    }

    public void saveDepartment(Department department) {
        this.departmentRepository.save(department);
    }

    public Department getDepartmentById(long id) {
        Optional<Department> optional = this.departmentRepository.findById(id);
        Department department = null;
        if (optional.isPresent()) {
            department = (Department)optional.get();
            return department;
        } else {
            throw new RuntimeException("Department not found for id :: " + id);
        }
    }

    public void deleteDepartmentById(long id) {
        this.departmentRepository.deleteById(id);
    }

    public List<Department> findAllDepartmentByNameDesc() {
        return this.departmentRepository.findAllDepartmentByNameDesc();
    }

    public List<Department> findAllDepartmentByNameAsc() {
        return this.departmentRepository.findAllDepartmentByNameAsc();
    }
}
