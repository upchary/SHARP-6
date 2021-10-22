package com.sharp.sharp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sharp.sharp.entity.LoginSession;
import com.sharp.sharp.repository.LoginRepository;
import com.sharp.sharp.service.LoginService;
import com.sharp.sharp.util.Constants;
@Component
@Transactional
public class LoginserviceImplementation implements LoginService {
	@Autowired
	private LoginRepository loginDao;

	@Override
	public LoginSession insertLogin(LoginSession login) {
		// TODO Auto-generated method stub
		LoginSession loginObj = new LoginSession();
		try {
			loginObj = loginDao.save(login);
		} catch (Exception e) {
			// TODO: handle exception
			loginObj = null;
		}
		return loginObj;
	}

	@Override
	public String deleteLogin(String userId, String logouttime) {
		try {
			LoginSession userLogout = loginDao.userLogout(userId, logouttime);
			return Constants.SUCCESS;

		} catch (Exception e) {
			return Constants.FAILURE;
		}

	}

}
