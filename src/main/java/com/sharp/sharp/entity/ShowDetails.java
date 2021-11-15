package com.sharp.sharp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "showdetails")
public class ShowDetails {

	@Id
	private String showid;
	private String categorieid;
	private String languageid;
	private String channelid;
//	@Lob
	@Transient
	private String logo;//need to add this in db 

	public String getShowid() {
		return showid;
	}

	public void setShowid(String showid) {
		this.showid = showid;
	}

	public String getCategorieid() {
		return categorieid;
	}

	public void setCategorieid(String categorieid) {
		this.categorieid = categorieid;
	}

	public String getLanguageid() {
		return languageid;
	}

	public void setLanguageid(String languageid) {
		this.languageid = languageid;
	}

	public String getChannelid() {
		return channelid;
	}

	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
