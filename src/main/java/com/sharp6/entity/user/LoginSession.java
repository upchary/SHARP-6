package com.sharp6.entity.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class LoginSession {
	@Id
	private String sessionID;

	private String emai;
	private String userId;

	private String deviceType;

	private String deviceIdentity_primary;

	private String deviceIdentity_secondary;

	private String login_lattitude;

	private String login_longitude;

	private String loginTime;
	private String logouttime;
	@Transient
	private String role;

	@Transient
	private String password;

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceIdentity_primary() {
		return deviceIdentity_primary;
	}

	public void setDeviceIdentity_primary(String deviceIdentity_primary) {
		this.deviceIdentity_primary = deviceIdentity_primary;
	}

	public String getDeviceIdentity_secondary() {
		return deviceIdentity_secondary;
	}

	public void setDeviceIdentity_secondary(String deviceIdentity_secondary) {
		this.deviceIdentity_secondary = deviceIdentity_secondary;
	}

	public String getLogin_lattitude() {
		return login_lattitude;
	}

	public void setLogin_lattitude(String login_lattitude) {
		this.login_lattitude = login_lattitude;
	}

	public String getLogin_longitude() {
		return login_longitude;
	}

	public void setLogin_longitude(String login_longitude) {
		this.login_longitude = login_longitude;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLogouttime() {
		return logouttime;
	}

	public void setLogouttime(String logouttime) {
		this.logouttime = logouttime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmai() {
		return emai;
	}

	public void setEmai(String emai) {
		this.emai = emai;
	}
	

}
