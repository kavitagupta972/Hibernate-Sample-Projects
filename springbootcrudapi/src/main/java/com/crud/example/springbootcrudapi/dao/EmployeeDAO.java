package com.crud.example.springbootcrudapi.dao;


import java.util.List;

import com.crud.example.springbootcrudapi.model.Employee;

public interface EmployeeDAO {
	
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
}