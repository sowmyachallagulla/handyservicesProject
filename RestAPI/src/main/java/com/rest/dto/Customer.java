package com.rest.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity

public class Customer {
	@Id@GeneratedValue
	private int cusId;
	private String cusName;
	private String email;
	private String phno;
	private String password;
	
	@OneToMany(mappedBy="customer",fetch = FetchType.LAZY)
	private Set<Service> serList =new HashSet<Service>();
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Service> getSerList() {
		return serList;
	}
	public void setSerList(Set<Service> serList) {
		this.serList = serList;
	}
	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", cusName=" + cusName + ", email=" + email + ", phno=" + phno
				+ ", password=" + password + "]";
	}
	
	

			}


