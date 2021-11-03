package com.sharp.sharp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sharp.sharp.entity.Language;
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
	private UserRepository userdao;
	@Autowired
	private LoginRepository loginDao;

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
	public UserMaster userLogin(LoginSession entity) {
		try {
			if (getUser(entity).equals(Constants.SUCCESS)) {
				UserMaster userLogin = userdao.getUser(entity.getEmail(), entity.getPassword());

				System.out.println(userLogin.getEmail());
				return userLogin;
			} else {

				return null;
			}
		} catch (

		Exception e) {
			return null;
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
			UserMaster byId = userdao.getById(user.getUserId());
			byId.setPassword(user.getPassword());
			UserMaster save = userdao.save(byId);
			return Constants.SUCCESS;
		} catch (Exception e) {
			return Constants.FAILURE;
		}

	}

	@Override
	public List<Language> getALLLanguages() {
		// TODO Auto-generated method stub
		return userdao.getALLLanguages();
	}

}
