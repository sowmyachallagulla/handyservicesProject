package com.rest.dto;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Service {
	@Id@GeneratedValue
	private int servId;
	@OneToOne
	@JoinColumn(name="handId")
	private Handyman handy;
	
	@ManyToOne
	@JoinColumn(name="cusId")
	private Customer customer;
	
	private Date bookingDate;
	private String bookedTime;
	private String issue;
	private String statusOfWork;
	
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public int getServId() {
		return servId;
	}
	public void setServId(int servId) {
		this.servId = servId;
	}
	
	
	public Handyman getHandy() {
		return handy;
	}
	public void setHandy(Handyman handy) {
		this.handy = handy;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getBookedTime() {
		return bookedTime;
	}
	public void setBookedTime(String bookedTime) {
		this.bookedTime = bookedTime;
	}
	public String getStatusOfWork() {
		return statusOfWork;
	}
	public void setStatusOfWork(String statusOfWork) {
		this.statusOfWork = statusOfWork;
	}
	
	public Service() {
		super();
		this.statusOfWork="not completed";
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Service [servId=" + servId + ", handy=" + handy + ", customer=" + customer + ", bookingDate="
				+ bookingDate + ", bookedTime=" + bookedTime + ", issue=" + issue + ", statusOfWork=" + statusOfWork
				+ "]";
	}
	
	
	}
