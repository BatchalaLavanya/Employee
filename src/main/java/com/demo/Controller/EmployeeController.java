package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Service.ServiceInterface;
import com.demo.entity.Employee;

@RequestMapping(value="/employee")
@RestController
public class EmployeeController {
	@Autowired
	private ServiceInterface service;
	
	@PostMapping(value="/add",consumes="application/json",produces="application/json")
	ResponseEntity<Employee> addEmployee(@RequestBody Employee e){
		int id=service.addEmployee(e);
		return ResponseEntity.ok(e);
		
	}
	@GetMapping(value="/show",produces="application/json")
	ResponseEntity<List<Employee>> showEmployee(){
		List<Employee> emp_list=service.showEmployee();
		if(emp_list.isEmpty()) {
			return new ResponseEntity("Sorrry ! not avaliabale",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(emp_list,HttpStatus.OK);
	}
	@PutMapping(path="/update/{id}")
	ResponseEntity<Employee> updateEmployee(@RequestBody Employee e){
		int result=service.updateEmployee(e);
		
		return ResponseEntity.status(400).build();
		
	}
	@DeleteMapping(path="/delete/{id}")
	ResponseEntity<Employee> delete(@PathVariable("id")Integer id){
		Employee e=service.delete(id);
		return new ResponseEntity<Employee>(e,HttpStatus.OK);
	}
	
	
}
