package com.example.employeemanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.*;
import com.example.employeemanagement.Entity.*;
import com.example.employeemanagement.Repository.*;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Service
public class EmployeeService
{
	@Autowired
	EmployeeRepo repo;
	
	 // Add Employee
    public Employee addEmployee(Employee emp) {
        return repo.save(emp);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    // Get Employee By Id
    public Employee getEmployeeById(int id) {
        return repo.findById(id).orElse(null);
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }
	
    
 // Search Employee By Name
    public List<Employee> searchEmployee(String name) {
        return repo.findByNameContaining(name);
    }
    
    
    
    
    public Page<Employee> getEmployeesPage(Pageable pageable) {
        return repo.findAll(pageable);
    }
    
    
//  --------------------------Sorting-------------------------------------------------------  
    
    public List<Employee> sortEmployees(String field, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(field).descending()
                : Sort.by(field).ascending();

        return repo.findAll(sort);
    }
    
    
    
    public List<Employee> searchAndSortEmployees(
            String name, String field, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(field).descending()
                : Sort.by(field).ascending();

        return repo.findByNameContaining(name, sort);
    }
    
    
//    ----------------------------------------------------------------------------
    
    public boolean emailExists(String email) {
        return repo.existsByEmail(email);
    }
	
    
    public boolean emailExistsForOtherEmployee(String email, int id) {
        return repo.existsByEmailAndIdNot(email, id);
    }
    
    
    
    
    public Page<Employee> getEmployeesWithPaginationAndSorting(
            int page, int size, String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return repo.findAll(pageable);
    }
	
}





