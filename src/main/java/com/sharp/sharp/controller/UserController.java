package com.sharp.sharp.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sharp.sharp.entity.LoginSession;
import com.sharp.sharp.entity.OTPValidation;
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
		user.setUserName(split[0]);
		user.setActivestatus(true);

		user.setCreatedDate(String.valueOf(new Date().getTime()));

		UserMaster registerObj = userService.newUserRegister(user);
		// log files
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

	@RequestMapping(value = "/userLoginwithOTP/", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> userRegisterOTP(@RequestBody UserMaster user) {
		Map<String, Object> resultMap = new HashMap<>();
		Random rnd = new Random();
		int value = 100000 + rnd.nextInt(900000);
		String template = "Login Otp for SHARP Validation: ";
		try {
			String result = loginService.userRegisterOTP(user.getMobileNumber(), template, String.valueOf(value));
			if (Constants.SUCCESS.equals(result)) {
				Date date = new Date();
				OTPValidation otpValidationObj = new OTPValidation();
				otpValidationObj.setMobileNumber(user.getMobileNumber());
				otpValidationObj.setOtp("" + value);
				otpValidationObj.setType("Signup");
				otpValidationObj.setCreatedBy("USER");
				otpValidationObj.setSendDate(new Timestamp(date.getTime()));
				otpValidationObj.setCreatedDate(new Timestamp(date.getTime()));
				otpValidationObj.setExpireDate(new Timestamp(date.getTime() + (600000)));
				OTPValidation otpResStatus = loginService.insertOTPForValidation(otpValidationObj);
				System.out.println("otpResStatus::= " + otpResStatus);
				if (otpResStatus != null) {
					resultMap.put("status", Constants.SUCCESS);
					resultMap.put("message", "OTP has been send to given mobile number");
				} // resultMap.put("value", value);
				else {
					resultMap.put("status", Constants.FAILURE);
					resultMap.put("errorvalue", "Sending OTP not Success");
				}
			} else {
				resultMap.put("status", Constants.FAILURE);
				resultMap.put("errorvalue", "Sending OTP not Success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("status", Constants.FAILURE);
			resultMap.put("errorvalue", "Sending OTP not Success");
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}

	@RequestMapping(value = "/OtpValidation/", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> validateOTP(@RequestBody OTPValidation otpvalidation) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			OTPValidation result = loginService.validateOTP(otpvalidation);
			if (Constants.SUCCESS.equals(result)) {
				resultMap.put("errorvalue", "OTP validation Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("status", Constants.FAILURE);
			resultMap.put("errorvalue", "OTP validation Failed");
			resultMap.put("errorMessage", e.getMessage());
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
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
