package com.ts.dao;

import java.util.Date;
import java.util.List;

import com.rest.dto.Handyman;
import com.rest.dto.Service;
import com.rest.dto.ServiceT;
import com.ts.db.HibernateTemplate;

public class ServiceTDAO {

	public int register(ServiceT service) {
		System.out.println(service); 
		return HibernateTemplate.addObject(service);
	}
	
	public List<ServiceT> getAllServices(int cusId){
	List<ServiceT> services =HibernateTemplate.getObjectById(cusId);
		
		
		System.out.println("Inside All services ..."+services);
		return services;

	}
	
	public List<ServiceT> getAllServicesByHandy(int handId){
		List<ServiceT> services =HibernateTemplate.getObjectById(handId);
			
			
			System.out.println("Inside All services ..."+services);
			return services;

		}
	public Object checkTime(String date,String slot,int handId){
		return HibernateTemplate.getHandyTime(date, slot,handId);
			
	}

}
