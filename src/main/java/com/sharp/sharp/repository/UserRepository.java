package com.sharp.sharp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sharp.sharp.entity.LoginSession;
import com.sharp.sharp.entity.UserMaster;

@Repository
public interface UserRepository extends JpaRepository<UserMaster, String> {

	@Query(value = "SELECT * FROM user_master WHERE email = ?1 and password = ?2 and activestatus=1", nativeQuery = true)
	UserMaster getUser(String emailAddress, String password);

	@Query(value = "SELECT * FROM login_session WHERE email = ?1 and password = ?2", nativeQuery = true)
	LoginSession userLogin(String emailAddress, String password);

	@Query(value = "update logouttime=?2 FROM login_session WHERE userId = ?1 ", nativeQuery = true)
	LoginSession userLogout(String userId, String logouttime);

	@Query(value = "update password=?2 FROM login_session WHERE userId = ?1 ", nativeQuery = true)
	UserMaster changePassword(String userId, String password);
}
