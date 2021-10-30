package com.sharp.sharp.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharp.sharp.entity.LoginSession;
import com.sharp.sharp.entity.UserMaster;
import com.sharp.sharp.service.LoginService;
import com.sharp.sharp.service.UserService;
import com.sharp.sharp.util.Constants;
import com.sharp.sharp.util.Sharp6Validation;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private LoginService loginService;

	@PostMapping("/newRegister/")
	public HashMap<String, Object> newUserRegister(@RequestBody UserMaster user) {
		HashMap<String, Object> resultMap = new HashMap<>();
		String[] split = user.getEmail().split("@");
		user.setUserId(split[0]);
		user.setActivestatus(true);

		user.setCreatedDate(String.valueOf(new Date().getTime()));

		UserMaster registerObj = userService.newUserRegister(user);
		System.out.println("object registerd in db succesfully");
		System.out.println("changes");
		if (registerObj != null) {
			resultMap.put("status", "success");
			resultMap.put("value", registerObj);
		} else {
			resultMap.put("status", "failure");
			resultMap.put("value", "inpuError");
		}
		return resultMap;
	}

	@PostMapping("/Login/")
	public Map<String, Object> loginUser(@RequestBody LoginSession entity) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		UserMaster userLogin = userService.userLogin(entity);
		if (!Sharp6Validation.isEmpty(userLogin)) {
			entity.setRole(userLogin.getRole());
			LoginSession insertLogin = loginService.insertLogin(entity);
			if (!Sharp6Validation.isEmpty(insertLogin)) {
				System.out.println("Login succcess");
				map.put(Constants.STATUS, Constants.SUCCESS);
				map.put("value1", "Login Success");
				map.put("value", entity);
			} else {
				map.put(Constants.STATUS, Constants.FAILURE);
				map.put("value", "Username or Password incorrect");
			}
		} else {
			map.put(Constants.STATUS, Constants.FAILURE);
			map.put("value", "Username or Password incorrect");
		}

		return map;

	}

	@PostMapping("/Logout/")
	public Map<String, Object> logoutUser(@RequestBody LoginSession entity) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		try {

			String deleteLogin = loginService.deleteLogin(entity.getUserId(), entity.getLogouttime());
			System.out.println("userLogout successfull");
			map.put(Constants.STATUS, deleteLogin);
			map.put("value", "Logoutsuccessfull");
		} catch (Exception e) {

			map.put(Constants.STATUS, Constants.FAILURE);
			map.put("value", "ServerError");
		}

		return map;

	}

	@PostMapping(value = "/resetPassword/")
	public Map<String, Object> changePassword(@RequestBody UserMaster user) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			String status = userService.changePassword(user);
			System.out.println(status);
			if (status.equals(Constants.SUCCESS)) {
				map.put(Constants.STATUS, status);
				map.put("value", "password Updated Successfully");
			} else {
				map.put(Constants.STATUS, Constants.FAILURE);
				map.put("value", "password Not Updated");
			}
		} catch (Exception e) {

			map.put(Constants.STATUS, Constants.FAILURE);
			map.put("value", "Try again");
		}

		return map;
	}

}
