package com.sharp.sharp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharp.sharp.entity.LoginSession;
import com.sharp.sharp.entity.UserMaster;



@Service
@Transactional
public interface UserService {

	public UserMaster newUserRegister(UserMaster user);

	public String userLogin(LoginSession entity);

	public String deleteLogin(String userId,String logout);

	public String changePassword(UserMaster user);

}
