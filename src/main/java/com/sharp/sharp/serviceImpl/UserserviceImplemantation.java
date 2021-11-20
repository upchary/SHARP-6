package com.sharp.sharp.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sharp.sharp.entity.LoginSession;
import com.sharp.sharp.entity.Questions;
import com.sharp.sharp.entity.UserMaster;
import com.sharp.sharp.repository.LoginRepository;
import com.sharp.sharp.repository.QeryRepository;
import com.sharp.sharp.repository.UserRepository;
import com.sharp.sharp.service.UserService;
import com.sharp.sharp.util.Constants;
import com.sharp.sharp.util.Sharp6Validation;

@Component
@Transactional
public class UserserviceImplemantation implements UserService {
	private static final Logger logger = Logger.getLogger(UserserviceImplemantation.class);
	@Autowired
	private UserRepository userdao;
	@Autowired
	private LoginRepository loginDao;
	@Autowired
	private QeryRepository queryDao;

	@Override
	public UserMaster newUserRegister(UserMaster user) {

		UserMaster userObj = new UserMaster();
		try {
			userObj = userdao.save(user);

			return userObj;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public UserMaster userLogin(LoginSession entity) {
		try {

			UserMaster userLogin = getUser(entity);
			// if(!Sharp6Validation.isEmpty(userLogin.getUserlname()))
			userLogin.setUserName(userLogin.getUserfname() + " " + userLogin.getUserlname());
			System.out.println(userLogin.getUserid());
			return userLogin;

		} catch (

		Exception e) {
			return null;
		}

	}

	public UserMaster getUser(LoginSession entity) {
		try {
			UserMaster user = userdao.getUser(entity.getMobileNumber(), entity.getPassword());
			if (!Sharp6Validation.isEmpty(user) && user.isActivestatus()) {
				user.setUserName(user.getUserfname() + " " + user.getUserlname());
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public String changePassword(UserMaster user) {
		try {
			UserMaster byId = userdao.getById(user.getUserid());
			byId.setConfirmPassword(user.getConfirmPassword());
			UserMaster save = userdao.save(byId);
			return Constants.SUCCESS;
		} catch (Exception e) {
			return Constants.FAILURE;
		}

	}

	@Override
	public List<Object[]> getALLLanguages() {
		// TODO Auto-generated method stub
		return userdao.getALLLanguages();
	}

	@Override
	public Questions inserttQueries(Questions question) {
		// TODO Auto-generated method stub
		try {
			Questions questions = queryDao.save(question);
			return questions;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
