package com.sharp.sharp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharp.sharp.entity.LoginSession;
@Service
@Transactional
public interface LoginService {
	LoginSession insertLogin(LoginSession login);

	String deleteLogin(String userId, String logouttime);

}
