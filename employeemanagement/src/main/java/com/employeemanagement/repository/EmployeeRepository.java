package com.employeemanagement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeemanagement.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("FROM Employee ORDER BY name ASC")
    List<Employee> findAllEmployeeByNameAsc();

    @Query("FROM Employee ORDER BY name DESC")
    List<Employee> findAllEmployeeByNameDesc();

    @Query("FROM Employee ORDER BY age ASC")
    List<Employee> findAllEmployeeByAgeAsc();

    @Query("FROM Employee ORDER BY age DESC")
    List<Employee> findAllEmployeeByAgeDesc();

    @Query(
        value = " SELECT e FROM Employee e where Name like %?1%",
        nativeQuery = true
    )
    List<Employee> findEmployeeByKeyword(@Param("keyword") String keyword);
}
