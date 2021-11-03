package com.sharp.sharp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharp.sharp.entity.Language;
import com.sharp.sharp.entity.LoginSession;
import com.sharp.sharp.entity.UserMaster;

@Service
@Transactional
public interface UserService {

	public UserMaster newUserRegister(UserMaster user);

	public UserMaster userLogin(LoginSession entity);

	public String changePassword(UserMaster user);

	public List<Language> getALLLanguages();

}
