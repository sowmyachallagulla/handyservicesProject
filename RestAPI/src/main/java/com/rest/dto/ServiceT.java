package com.rest.dto;

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
public class ServiceT {
	@Id@GeneratedValue
	private int servId;
	private int cusId;
	private int handId;
	private String bookingDate;
	private String issue;
	private String statusOfWork;
	private String adrress;
	private String slot;
	private String handName;
	public int getServId() {
		return servId;
	}
	public void setServId(int servId) {
		this.servId = servId;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public int getHandId() {
		return handId;
	}
	public void setHandId(int handId) {
		this.handId = handId;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getStatusOfWork() {
		return statusOfWork;
	}
	public void setStatusOfWork(String statusOfWork) {
		this.statusOfWork = statusOfWork;
	}
	public String getAdrress() {
		return adrress;
	}
	public void setAdrress(String adrress) {
		this.adrress = adrress;
	}
	
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	public String getHandName() {
		return handName;
	}
	public void setHandName(String handName) {
		this.handName = handName;
	}
	@Override
	public String toString() {
		return "ServiceT [servId=" + servId + ", cusId=" + cusId + ", handId=" + handId + ", bookingDate=" + bookingDate
				+ ", issue=" + issue + ", statusOfWork=" + statusOfWork + ", adrress=" + adrress + ", slot=" + slot
				+ ", handName=" + handName + "]";
	}
	
	
	}