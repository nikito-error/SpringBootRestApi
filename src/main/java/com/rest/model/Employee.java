package com.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

//JsonIgnore to ignore name or age or smth in json put and other methods
//JsonProperty("full_name") change json name
@Entity
@Table(name = "tbl_employee")
public class Employee {
	@Id // GenerationType.Auto will work only under hibernate 5.0 version
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@NotBlank(message="Name should not be null")
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private Long age=0L;
	@Column(name = "location")
	private String location;
	@Email(message="Please enter valid email address")
	@Column(name = "email")
	private String email;
	@NotBlank(message="Depratment should not be null")
	@Column(name = "department")
	private String department;
	@CreationTimestamp
	@Column(name = "created_at",nullable=false,updatable=false)
	private Date createdDate;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updateDate;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", location=" + location + ", email=" + email
				+ ", department=" + department + ", createdDate=" + createdDate + ", updateDate=" + updateDate + "]";
	}



}
