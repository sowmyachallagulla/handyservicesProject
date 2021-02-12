package com.rest.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value="empList",allowSetters=true)

@XmlRootElement
@Entity
public class Department {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int deptId;
	private String deptName;
	private String location;
	
	@OneToMany(mappedBy="department",fetch = FetchType.LAZY)
	private Set<Employee> empList =new HashSet<Employee>();
	
	public Department() {
		super();
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(Set<Employee> empList) {
		this.empList = empList;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", location=" + location + "]";
	}
}