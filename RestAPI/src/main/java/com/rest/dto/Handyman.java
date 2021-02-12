package com.rest.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity

public class Handyman {
	@Id@GeneratedValue
	private int handId;
	private String handName;
	private String email;
	private String password;
	private float rating;
	private String role;
	
	private String handyImage;
	
	public int getHandId() {
		return handId;
	}
	public void setHandId(int handId) {
		this.handId = handId;
	}
	public String getHandName() {
		return handName;
	}
	public void setHandName(String handName) {
		this.handName = handName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getHandyImage() {
		return handyImage;
	}
	public void setHandyImage(String handyImage) {
		this.handyImage = handyImage;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Handyman [handId=" + handId + ", handName=" + handName + ", email=" + email + ", password=" + password
				+ ", rating=" + rating + ", role=" + role + ", handyImage=" + handyImage + "]";
	}
	
	
	
	}

