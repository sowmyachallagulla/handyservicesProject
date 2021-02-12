package com.ts.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.rest.dto.Customer;
import com.rest.dto.Department;
import com.rest.dto.Employee;
import com.rest.dto.Handyman;
import com.rest.dto.ServiceT;

public class HibernateTemplate {

	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	
	public static int addObject(Object obj)
	{
		System.out.println("Inside Template...");
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;
		
		try {			
			return sessionFactory.openSession().get(c,serializable);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public static Object getObjectByUserPass(String loginId,String password) {
	
	String queryString = "from Customer where email = :loginId and password =:password";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setString("loginId", loginId);
	  query.setString("password", password);
	  Object queryResult = query.uniqueResult();
	  Customer customer =(Customer)queryResult;
	  return customer;
	}
	
	public static Object getHandymanByUserPass(String loginId,String password) {
		
		String queryString = "from Handyman where email = :loginId and password =:password";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("loginId", loginId);
		  query.setString("password", password);
		  Object queryResult = query.uniqueResult();
		  Handyman handyman =(Handyman)queryResult;
		  return handyman;
		}
	public static Object getObjectByEmail(String email) {
		
		String queryString = "from Employee where email = :email";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("email", email);
		  Object queryResult = query.uniqueResult();
		  Employee employee = (Employee)queryResult;
		  return employee; 
		}
	public static Object getHandyTime(String bookingDate,String slot,int handId) {
		
		String queryString = "from ServiceT where bookingDate = :bookingDate and slot =:slot and handId =:handId";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("bookingDate", bookingDate);
		  query.setString("slot", slot);
		  query.setInteger("handId", handId);
		  Object queryResult = query.uniqueResult();
		  ServiceT service =(ServiceT)queryResult;
		  return service;
		}
	public static List<Object> getObjectListByQuery(String query)
	{
		return sessionFactory.openSession().createQuery(query).list();
	}
	
	public static int updateObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Object obj=session.get(c,serializable);
			
			session.delete(obj);
			
			tx.commit();
			
			result=1;
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
		}
		
		return result;
	}

	public static List<Object> getObjectListByName(Class c, String columName, String value) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(c);
			Criterion nameCriterion = Restrictions.eq(columName, value);
			criteria.add(nameCriterion);
			return criteria.list();
	}
	
	public static List<Handyman> getObjectByRole(String role) {
		
		String queryString = "from Handyman where role = :role";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("role", role);
		  List<Handyman> li= query.list();
		  return li;
		}
		
public static List<ServiceT> getObjectById(int cusId) {
		
		String queryString = "from ServiceT where cusId = :cusId";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setInteger("cusId", cusId);
		  List<ServiceT> li= query.list();
		  return li;
		}
public static void updateRating(int handId,int rating){
	
    Session session = sessionFactory.openSession();

    Transaction tx = session.beginTransaction();
    Handyman handyman = (Handyman) session.load(Handyman.class, handId);
    //student.setName("Johnson");
    float rating1=handyman.getRating();
    handyman.setRating((rating+rating1)/2);
    session.update(handyman);
    tx.commit();
    session.close();

}

public static void deleteService(int servId){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sql = "delete FROM ServiceT WHERE servId = :servId";
        Query query = session.createQuery(sql);
        query.setInteger("servId", servId);
         int row = query.executeUpdate();
         if (row == 0)
             System.out.println("Doesnt deleted any row!");
         else
             System.out.println("Deleted Row: "+ row);
        session.getTransaction().commit();
        session.close();
    }

public static Object getObjectByhandyman(int handId) {
	
	String queryString = "from Handyman where handId = :handId";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setInteger("handId", handId);
	  Object queryResult = query.uniqueResult();
	  Handyman handyman = (Handyman)queryResult;
	  return handyman; 
	}

public static Object getObjectByCustomer(int cusId) {
	
	String queryString = "from Customer where cusId = :cusId";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setInteger("cusId", cusId);
	  Object queryResult = query.uniqueResult();
	  Customer customer = (Customer)queryResult;
	  return customer; 
	}

	
}
