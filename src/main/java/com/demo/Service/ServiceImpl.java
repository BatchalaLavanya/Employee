package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.DaoInterface;
import com.demo.entity.Employee;
@Service
public class ServiceImpl implements ServiceInterface{
	@Autowired
	DaoInterface dao;
	
	@Override
	public int addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return dao.addEmployee(e);
	}

	@Override
	public List<Employee> showEmployee() {
		// TODO Auto-generated method stub
		List<Employee> emp_list=dao.showEmployee();
		return emp_list;
	}

	@Override
	public int updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(e);
		
	}
	public Employee delete(int id) {
		return dao.delete(id);
		
	}
	

}
