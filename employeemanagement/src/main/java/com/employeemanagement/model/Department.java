package com.employeemanagement.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(
    name = "department"
)
public class Department {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "department_id"
    )
    private long id;
    @Column(
        name = "name"
    )
    private String name;
    @OneToMany(
        cascade = {CascadeType.ALL},
        mappedBy = "department",
        orphanRemoval = true
    )
    private Set<Employee> employee;

    public Department() {
    }

    public String toString() {
        return "Department [id=" + this.id + ", name=" + this.name + "]";
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

    public void setName(String name) {
        this.name = name;
    }
}
