package com.example.employeemanagement.RestController;

//package com.example.employeemanagement.Controller;



//----------Pagination API--------------------
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.employeemanagement.Entity.Employee;
import com.example.employeemanagement.Service.EmployeeService;


import org.springframework.http.ResponseEntity;			//Response Entity likee postman-OK200, 404,500 

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController 
{

    @Autowired
    EmployeeService service;

    // Get All Employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() 
    {

        List<Employee> employees = service.getAllEmployees();

        return ResponseEntity.ok(employees);
    }

    // Get Employee By ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id) {

        Employee emp = service.getEmployeeById(id);

        if (emp == null) {
            return ResponseEntity.status(404)
                    .body("Employee not found with ID: " + id);
        }

        return ResponseEntity.ok(emp);
    }
    
    @GetMapping("/page")
    public ResponseEntity<Page<Employee>> getEmployeesByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Employee> employees = service.getEmployeesPage(pageable);

        return ResponseEntity.ok(employees);
    }
    
    
    
    @GetMapping("/sort")
    public ResponseEntity<List<Employee>> sortEmployees(
            @RequestParam(defaultValue = "name") String field,
            @RequestParam(defaultValue = "asc") String direction) 
    {

        List<Employee> employees = service.sortEmployees(field, direction);

        return ResponseEntity.ok(employees);
    }
    
    
    
    @GetMapping("/page-sort")
    public ResponseEntity<Page<Employee>> getEmployeesWithPaginationAndSorting(

            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) 
    {

        Page<Employee> employees =
                service.getEmployeesWithPaginationAndSorting(
                        page, size, sortBy, direction);

        return ResponseEntity.ok(employees);
    }
//    ---------------------------------------------------------------------------

    // Add Employee
    @PostMapping
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee emp) 
    {

        if (service.emailExists(emp.getEmail())) 
        {
        	return ResponseEntity.status(409)
        	        .body("Email already exists!");
        }

        Employee savedEmployee = service.addEmployee(emp);

        return ResponseEntity.status(201).body(savedEmployee);
    }
    
    
    // Update Employee
    @PutMapping
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody Employee emp) {

        Employee existingEmployee = service.getEmployeeById(emp.getId());

        if (existingEmployee == null) {
            return ResponseEntity.status(404)
                    .body("Employee not found with ID: " + emp.getId());
        }

        if (service.emailExistsForOtherEmployee(emp.getEmail(), emp.getId())) {
            return ResponseEntity.status(409)
                    .body("Email already exists!");
        }

        Employee updatedEmployee = service.addEmployee(emp);

        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {

        Employee emp = service.getEmployeeById(id);

        if (emp == null) {
            return ResponseEntity.status(404)
                    .body("Employee not found with ID: " + id);
        }

        service.deleteEmployee(id);

        return ResponseEntity.ok("Employee Deleted Successfully");
    }
    
    
    
}
