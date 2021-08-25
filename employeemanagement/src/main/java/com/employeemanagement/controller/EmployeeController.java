package com.employeemanagement.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employeemanagement.model.Employee;
import com.employeemanagement.services.DepartmentService;
import com.employeemanagement.services.EmployeeService;

@Controller
public class EmployeeController {
    Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    private static int sortDirectionName = 1;
    private static int sortDirectionAge = 1;

    public EmployeeController() {
    }

    @GetMapping({"/"})
    public String getAllEmployee(Model model) {
        model.addAttribute("listEmployees", this.employeeService.getAllEmployee());
        this.logger.trace("Home page");
        return "index";
    }

    @GetMapping({"/addNewEmployee"})
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", this.departmentService.getAllDepartment());
        return "new_employee";
    }

    @PostMapping({"/saveEmployee"})
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        this.employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping({"/showFormUpdate/{id}"})
    public String showFormUpdate(@PathVariable("id") long id, Model model) {
        Employee employee = this.employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("departments", this.departmentService.getAllDepartment());
        return "update_employee";
    }

    @GetMapping({"/deleteEmployee/{id}"})
    public String deleteEmployee(@PathVariable("id") long id) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

    @GetMapping({"/sort-by-employee-name"})
    public String sortByName(Model model) {
        List employeeListAsc;
        if (sortDirectionName == 0) {
            sortDirectionName = 1;
            employeeListAsc = this.employeeService.findAllEmployeeByNameDesc();
            model.addAttribute("listEmployees", employeeListAsc);
            return "index";
        } else {
            sortDirectionName = 0;
            employeeListAsc = this.employeeService.findAllEmployeeByNameAsc();
            model.addAttribute("listEmployees", employeeListAsc);
            return "index";
        }
    }

    @GetMapping({"/sort-by-employee-age"})
    public String sortByAge(Model model) {
        List employeeListAsc;
        if (sortDirectionAge == 0) {
            sortDirectionAge = 1;
            employeeListAsc = this.employeeService.findAllEmployeeByAgeDesc();
            model.addAttribute("listEmployees", employeeListAsc);
            return "index";
        } else {
            sortDirectionAge = 0;
            employeeListAsc = this.employeeService.findAllEmployeeByAgeAsc();
            model.addAttribute("listEmployees", employeeListAsc);
            return "index";
        }
    }

    @GetMapping({"/search"})
    public String searchEmployee(String keyword, Model model) {
        if (keyword != null) {
            model.addAttribute("listEmployee", this.employeeService.findEmployeeByKeyword(keyword));
        } else {
            model.addAttribute("listEmployee", this.employeeService.getAllEmployee());
        }

        return "index";
    }
}