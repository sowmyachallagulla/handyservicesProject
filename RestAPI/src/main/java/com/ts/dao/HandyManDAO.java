package com.ts.dao;

import java.util.List;

import com.rest.dto.Employee;
import com.rest.dto.Handyman;
import com.ts.db.HibernateTemplate;

public class HandyManDAO {

	public List<Handyman> getAllHandyman() {
		List<Handyman> handymans=(List)HibernateTemplate.getObjectListByQuery("From Handyman");
		System.out.println("Inside All handymans ..."+handymans);
		return handymans;
	}
	
	public int addHandyman(Handyman h){
		return HibernateTemplate.addObject(h);
		}
	
	public List<Handyman> getHandymanByRole(String role) {
		List<Handyman> handymans =HibernateTemplate.getObjectByRole(role);
		
		
		System.out.println("Inside All handymans ..."+handymans);
		return handymans;
	}
	
	public int updateRating(Handyman handyman){
		int result=(int) HibernateTemplate.updateObject(handyman);
		return result;
	}
	
	public Handyman getHandymanById(int handId) {
		Handyman handyman =(Handyman) HibernateTemplate.getObjectByhandyman(handId);
		
		
		System.out.println("Inside All handymans ..."+handyman);
		return handyman;
	}
	
	public Object checkUser(String loginId,String password){
		return HibernateTemplate.getHandymanByUserPass(loginId,password);
			
	}



}
