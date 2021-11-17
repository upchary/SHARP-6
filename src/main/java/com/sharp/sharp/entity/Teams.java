package com.sharp.sharp.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Teams {

	@Id
	private String teamid;
	private String temanme;
	private String teamdesc;
	private Timestamp createddate;
	public String getTeamid() {
		return teamid;
	}
	public void setTeamid(String teamid) {
		this.teamid = teamid;
	}
	public String getTemanme() {
		return temanme;
	}
	public void setTemanme(String temanme) {
		this.temanme = temanme;
	}
	public String getTeamdesc() {
		return teamdesc;
	}
	public void setTeamdesc(String teamdesc) {
		this.teamdesc = teamdesc;
	}
	public Timestamp getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}
	
}
