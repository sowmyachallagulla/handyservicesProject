package com.ts.dao;

import org.hibernate.SessionFactory;

import com.rest.dto.Customer;
import com.rest.dto.Employee;
import com.rest.dto.Handyman;
import com.ts.db.HibernateTemplate;

public class CustomerDAO {
	private SessionFactory factory = null;

	public int register(Customer customer) {
		System.out.println("hi"); 
		return HibernateTemplate.addObject(customer);
	}
	public Object checkUser(String loginId,String password){
		return HibernateTemplate.getObjectByUserPass(loginId,password);
			
	}
	public Customer getCustomerById(int cusId) {
		Customer customer =(Customer) HibernateTemplate.getObjectByCustomer(cusId);
		
		
		System.out.println("Inside All handymans ..."+customer);
		return customer;
	}
	public int update(Customer editUser) {
		System.out.println(editUser); 
		return HibernateTemplate.updateObject(editUser);
	}
}
