package com.example.employeemanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.employeemanagement.Entity.Employee;
import com.example.employeemanagement.Service.EmployeeService;



import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService service;

    // Home Page
    @GetMapping("/")
    public String home(Model model) {

        List<Employee> employees = service.getAllEmployees();
        Map<String, Long> departmentCounts = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        TreeMap::new,
                        Collectors.counting()
                ));

        model.addAttribute("departmentCounts", departmentCounts);
        
        

        long totalEmployees = employees.size();

        long itEmployees = employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("IT"))
                .count();

        long hrEmployees = employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("HR"))
                .count();

        long financeEmployees = employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("Finance"))
                .count();

        model.addAttribute("totalEmployees", totalEmployees);
        model.addAttribute("itEmployees", itEmployees);
        model.addAttribute("hrEmployees", hrEmployees);
        model.addAttribute("financeEmployees", financeEmployees);

        return "index";
    }

    // Add Employee
    @PostMapping("/add")
    public String addEmployee(Employee emp, Model model) {

        if (service.emailExists(emp.getEmail())) {

            model.addAttribute("errorMessage",
                    "This email already exists! Please use another email.");

            return "add-employee";
        }

        service.addEmployee(emp);

        return "redirect:/employees";
    }
    // View All Employees
    @GetMapping("/employees")
    public String getAllEmployees(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            Model model) {

        List<Employee> list = service.sortEmployees(sortBy, direction);

        model.addAttribute("employees", list);

        model.addAttribute("selectedSort", sortBy);
        model.addAttribute("selectedDirection", direction);

        return "employees";
    }

    // Delete Employee
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return "redirect:/employees";
    }
    
    
    @GetMapping("/add-employee")
    public String addEmployeePage() {
        return "add-employee";
    }
    
 // Show Edit Form
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable int id, Model model) {

        Employee emp = service.getEmployeeById(id);

        model.addAttribute("employee", emp);

        return "edit-employee";
    }

    // Update Employee
    @PostMapping("/update")
    public String updateEmployee(Employee emp) {

        service.addEmployee(emp);

        return "redirect:/employees";
    }
    
    
    
 // Search Employee
    @GetMapping("/search")
    public String searchEmployee(
            @RequestParam String name,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            Model model) {

        List<Employee> list =
                service.searchAndSortEmployees(name, sortBy, direction);

        model.addAttribute("employees", list);
        model.addAttribute("searchName", name);
        model.addAttribute("selectedSort", sortBy);
        model.addAttribute("selectedDirection", direction);

        return "search-result";
    }
    
}