package com.employeemanagement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeemanagement.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("FROM Department ORDER BY name ASC")
    List<Department> findAllDepartmentByNameAsc();

    @Query("FROM Department ORDER BY name DESC")
    List<Department> findAllDepartmentByNameDesc();
}
