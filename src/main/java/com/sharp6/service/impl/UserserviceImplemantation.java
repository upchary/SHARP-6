package com.sharp6.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sharp6.entity.user.LoginSession;
import com.sharp6.entity.user.UserMaster;
import com.sharp6.repository.UserRepositoryy;
import com.sharp6.service.UserServicee;
import com.sharp6.util.Constants;

@Component
@Transactional
public class UserserviceImplemantation implements UserServicee {
	@Autowired
	UserRepositoryy userdao;

	@Override
	public com.sharp6.entity.user.UserMaster newUserRegister(UserMaster user) {

		UserMaster userObj = new UserMaster();
		try {
			userObj = userdao.save(user);

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return userObj;
	}

	@Override
	public String userLogin(LoginSession entity) {
		// TODO Auto-generated method stub
		try {
			if (!getUser(entity).equals(Constants.SUCCESS)) {
				LoginSession userLogin = userdao.userLogin(entity.getEmai(), entity.getPassword());
				System.out.println(userLogin.getEmai());
				return Constants.SUCCESS;
			}
			return Constants.FAILURE;
		} catch (

		Exception e) {
			// TODO: handle exception
			return Constants.FAILURE;
		}

	}

	@Override
	public String deleteLogin(String userId,String logouttime) {
		// TODO Auto-generated method stub
		try {
			LoginSession userLouserLogout = userdao.userLogout(userId,logouttime);
			return Constants.SUCCESS;

		} catch (Exception e) {
			// TODO: handle exception
			return Constants.FAILURE;
		}

	}

	public String getUser(LoginSession entity) {
		try {
			UserMaster user = userdao.getUser(entity.getEmai(), entity.getPassword());
			return Constants.SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			return Constants.FAILURE;
		}

	}

	@Override
	public String changePassword(UserMaster user) {
		// TODO Auto-generated method stub
		try {

			userdao.changePassword(user.getUserId(), user.getPassword());
			return Constants.SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			return Constants.FAILURE;
		}

	}

}
