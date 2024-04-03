package com.demo.Service;

import java.util.List;

import com.demo.entity.Employee;

public interface ServiceInterface {
	public int addEmployee(Employee e);
	public List<Employee> showEmployee();
	public int updateEmployee(Employee e);
	public Employee delete(int id);

}
