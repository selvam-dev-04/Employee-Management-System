package com.example.employeemanagement.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employeemanagement.Entity.*;
import java.util.*;
import org.springframework.data.domain.Sort;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>
{
	List<Employee> findByNameContaining(String name);
	
	boolean existsByEmail(String email);
	
	boolean existsByEmailAndIdNot(String email, int id);
	List<Employee> findByNameContaining(String name, Sort sort);
}