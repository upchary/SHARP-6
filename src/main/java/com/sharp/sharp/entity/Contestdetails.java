package com.sharp.sharp.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "contestdetails")
public class Contestdetails {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String contestid;
	private String showid;
	private String languageid;
	private String categorieid;
	private String statusid;
	private String userid;
	private String channelid;
	private String teamid;
	private int totalcontestprice;
	private String qid;
	private int playersjoined;
	private int totalplayers;
	private String contestdisplayname;
	private String categorielist;
	private Timestamp contestdate;
	private String contesttime;
	private String language;
	private String teamname1_shotname;
	private String teamname2_shotname;
	private int price;
	private int minplayers;
	private int maxplayers;
	private Timestamp createddate;
	@Transient
	private String statusname;
	@Transient
	private String statusdesc;

	@Transient
	private String temanme;
	@Transient
	private String teamdesc;

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

	public String getStatusname() {
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	public String getStatusdesc() {
		return statusdesc;
	}

	public void setStatusdesc(String statusdesc) {
		this.statusdesc = statusdesc;
	}

	public String getContestid() {
		return contestid;
	}

	public void setContestid(String contestid) {
		this.contestid = contestid;
	}

	public String getShowid() {
		return showid;
	}

	public void setShowid(String showid) {
		this.showid = showid;
	}

	public String getLanguageid() {
		return languageid;
	}

	public void setLanguageid(String languageid) {
		this.languageid = languageid;
	}

	public String getCategorieid() {
		return categorieid;
	}

	public void setCategorieid(String categorieid) {
		this.categorieid = categorieid;
	}

	public String getStatusid() {
		return statusid;
	}

	public void setStatusid(String statusid) {
		this.statusid = statusid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getChannelid() {
		return channelid;
	}

	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}

	public String getTeamid() {
		return teamid;
	}

	public void setTeamid(String teamid) {
		this.teamid = teamid;
	}

	public int getTotalcontestprice() {
		return totalcontestprice;
	}

	public void setTotalcontestprice(int totalcontestprice) {
		this.totalcontestprice = totalcontestprice;
	}

	public String getQid() {
		return qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	public int getPlayersjoined() {
		return playersjoined;
	}

	public void setPlayersjoined(int playersjoined) {
		this.playersjoined = playersjoined;
	}

	public int getTotalplayers() {
		return totalplayers;
	}

	public void setTotalplayers(int totalplayers) {
		this.totalplayers = totalplayers;
	}

	public String getContestdisplayname() {
		return contestdisplayname;
	}

	public void setContestdisplayname(String contestdisplayname) {
		this.contestdisplayname = contestdisplayname;
	}

	public String getCategorielist() {
		return categorielist;
	}

	public void setCategorielist(String categorielist) {
		this.categorielist = categorielist;
	}

	public Timestamp getContestdate() {
		return contestdate;
	}

	public void setContestdate(Timestamp contestdate) {
		this.contestdate = contestdate;
	}

	public String getContesttime() {
		return contesttime;
	}

	public void setContesttime(String contesttime) {
		this.contesttime = contesttime;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTeamname1_shotname() {
		return teamname1_shotname;
	}

	public void setTeamname1_shotname(String teamname1_shotname) {
		this.teamname1_shotname = teamname1_shotname;
	}

	public String getTeamname2_shotname() {
		return teamname2_shotname;
	}

	public void setTeamname2_shotname(String teamname2_shotname) {
		this.teamname2_shotname = teamname2_shotname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMinplayers() {
		return minplayers;
	}

	public void setMinplayers(int minplayers) {
		this.minplayers = minplayers;
	}

	public int getMaxplayers() {
		return maxplayers;
	}

	public void setMaxplayers(int maxplayers) {
		this.maxplayers = maxplayers;
	}

	public Timestamp getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}

}
