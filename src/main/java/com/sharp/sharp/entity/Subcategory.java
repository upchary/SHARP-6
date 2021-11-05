package com.sharp.sharp.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Subcategory {

	@Id
	private String subcategoryid;

	private String subcategoryname;

	private String subcategorydesc;
	private Timestamp createddate;

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "categoryid") private Category category;
	 */

	public String getSubcategoryid() {
		return subcategoryid;
	}

	public void setSubcategoryid(String subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	public String getSubcategoryname() {
		return subcategoryname;
	}

	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}

	public String getSubcategorydesc() {
		return subcategorydesc;
	}

	public void setSubcategorydesc(String subcategorydesc) {
		this.subcategorydesc = subcategorydesc;
	}

	public Timestamp getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}

	/*
	 * public Category getCategory() { return category; }
	 * 
	 * public void setCategory(Category category) { this.category = category; }
	 */

}
