package com.sharp.sharp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sharp.sharp.entity.LoginSession;
import com.sharp.sharp.entity.UserMaster;
import com.sharp.sharp.repository.LoginRepository;
import com.sharp.sharp.repository.UserRepository;
import com.sharp.sharp.service.UserService;
import com.sharp.sharp.util.Constants;



@Component
@Transactional
public class UserserviceImplemantation implements UserService {
	@Autowired
	UserRepository userdao;
	@Autowired
	LoginRepository loginDao;

	@Override
	public UserMaster newUserRegister(UserMaster user) {

		UserMaster userObj = new UserMaster();
		try {
			userObj = userdao.save(user);

		} catch (Exception e) {
			return null;
		}
		return userObj;
	}

	@Override
	public String userLogin(LoginSession entity) {
		try {
			if (getUser(entity).equals(Constants.SUCCESS)) {
				LoginSession userLogin = userdao.userLogin(entity.getEmail(), entity.getPassword());

				System.out.println(userLogin.getEmail());
				return Constants.SUCCESS;
			} else {

				return Constants.FAILURE;
			}
		} catch (

		Exception e) {
			return Constants.FAILURE;
		}

	}

	

	public String getUser(LoginSession entity) {
		try {
			UserMaster user = userdao.getUser(entity.getEmail(), entity.getPassword());
			return Constants.SUCCESS;
		} catch (Exception e) {
			return Constants.FAILURE;
		}

	}

	@Override
	public String changePassword(UserMaster user) {
		try {

			userdao.changePassword(user.getUserId(), user.getPassword());
			return Constants.SUCCESS;
		} catch (Exception e) {
			return Constants.FAILURE;
		}

	}

}
