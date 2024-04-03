package com.demo.Dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.demo.entity.Employee;
@Repository
public class DaoImpl implements DaoInterface{
	@PersistenceContext
	EntityManager em;
	@Transactional
	@Override
	public int addEmployee(Employee e) {
		// TODO Auto-generated method stub
		em.persist(e);
		int id=e.getId();
		return id;
	}
	@Transactional
	@Override
	public List<Employee> showEmployee() {
		// TODO Auto-generated method stub
		TypedQuery<Employee> emp_query=em.createQuery("Select e from Employee e",Employee.class);
		List<Employee> emp_list=emp_query.getResultList();
		Iterator<Employee> c=emp_list.iterator();
		while(c.hasNext()) {
			System.out.println(c.next());
		}
		return emp_list;
	}
	@Transactional
	@Override
	public int updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		em.merge(e);
		
		return e.getId();
	}
	public Employee delete(int id) {
		Employee e=em.find(Employee.class,id);
		em.remove(e);
		return e;
	}
	

}
