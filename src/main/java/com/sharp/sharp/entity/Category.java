package com.sharp.sharp.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Category {

	@Id
	private String categoryid;

	private String categoryname;

	private String categorydesc;
	private Timestamp createddate;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryid")
	private List<Subcategory> subcategoryid;

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategorydesc() {
		return categorydesc;
	}

	public void setCategorydesc(String categorydesc) {
		this.categorydesc = categorydesc;
	}

	public Timestamp getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}

	public List<Subcategory> getSubcategoryid() {
		return subcategoryid;
	}

	public void setSubcategoryid(List<Subcategory> subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	

}
