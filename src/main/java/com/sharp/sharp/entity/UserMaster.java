package com.sharp.sharp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users")
public class UserMaster {
	@Id
	private String userid;
	@Transient
	private String userName;
	private String userfname;
	private String userlname;
	private String password;
	@Transient
	private String confirmPassword;

	private String mobileNumber;
	private int age;
	private String address;
	// private String city;
	// private String state;
	// private String country;
	private Date dob;
	private String role;

	private boolean activestatus;
	@Column(name ="created_date")
	private String createdDate;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserfname() {
		return userfname;
	}

	public void setUserfname(String userfname) {
		this.userfname = userfname;
	}

	public String getUserlname() {
		return userlname;
	}

	public void setUserlname(String userlname) {
		this.userlname = userlname;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActivestatus() {
		return activestatus;
	}

	public void setActivestatus(boolean activestatus) {
		this.activestatus = activestatus;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
