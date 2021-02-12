package com.rest.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Rating {
	@Id@GeneratedValue
	private int rateId;
	
	@OneToOne
	private Customer customer;
	
	@OneToOne
	private Service ser;
	
	private String review;

	public int getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Service getSer() {
		return ser;
	}

	public void setSer(Service ser) {
		this.ser = ser;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Rating [rateId=" + rateId + ", customer=" + customer + ", ser=" + ser + ", review=" + review + "]";
	}
	
}

