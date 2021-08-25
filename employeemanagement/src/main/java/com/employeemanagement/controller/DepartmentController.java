package com.employeemanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employeemanagement.model.Department;
import com.employeemanagement.services.DepartmentService;

@Controller
public class DepartmentController {
    private static int sortDirection = 0;
    @Autowired
    private DepartmentService departmentService;

    public DepartmentController() {
    }

    @PostMapping({"/saveDepartment"})
    public String saveEmployee(@ModelAttribute("employee") Department department) {
        this.departmentService.saveDepartment(department);
        return "redirect:/department";
    }

    @GetMapping({"/department"})
    public String getAllDepartment(Model model) {
        model.addAttribute("listDepartment", this.departmentService.getAllDepartment());
        return "department";
    }

    @GetMapping({"/addNewDepartment"})
    public String addNewDepartmen(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        return "new_dept";
    }

    @GetMapping({"/departmentUpdate/{id}"})
    public String showFormUpdate(@PathVariable("id") long id, Model model) {
        Department department = this.departmentService.getDepartmentById(id);
        model.addAttribute("department", department);
        return "new_dept";
    }

    @GetMapping({"/deleteDepartment/{id}"})
    public String deleteEmployee(@PathVariable("id") long id) {
        this.departmentService.deleteDepartmentById(id);
        return "redirect:/department";
    }

    @GetMapping({"/sort-by-department-name"})
    public String sortByName(Model model) {
        List departmentListAsc;
        if (sortDirection == 0) {
            sortDirection = 1;
            departmentListAsc = this.departmentService.findAllDepartmentByNameAsc();
            model.addAttribute("listDepartment", departmentListAsc);
            return "department";
        } else {
            sortDirection = 0;
            departmentListAsc = this.departmentService.findAllDepartmentByNameDesc();
            model.addAttribute("listDepartment", departmentListAsc);
            return "department";
        }
    }
}
