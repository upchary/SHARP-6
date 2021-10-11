package com.sharp6.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharp6.entity.user.LoginSession;
import com.sharp6.entity.user.UserMaster;

@Service
@Transactional
public interface UserServicee {

	public UserMaster newUserRegister(UserMaster user);

	public String userLogin(LoginSession entity);

	public String deleteLogin(String userId,String logout);

	public String changePassword(UserMaster user);

}
