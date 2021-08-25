package com.employeemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(
    name = "employee"
)
public class Employee {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "employee_id"
    )
    private long id;
    @Column(
        name = "name"
    )
    private String name;
    @Column(
        name = "age"
    )
    private int age;
    @ManyToOne
    @JoinColumn(
        name = "department_id"
    )
    private Department department;

    public Employee() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Employee [id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", department=" + this.department + "]";
    }
}