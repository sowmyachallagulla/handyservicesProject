package com.ts.dao;

import com.rest.dto.Employee;
import com.rest.dto.Service;
import com.ts.db.HibernateTemplate;

public class ServiceDAO {
	public int register(Service service) {
		System.out.println(service); 
		return HibernateTemplate.addObject(service);
	}


}
