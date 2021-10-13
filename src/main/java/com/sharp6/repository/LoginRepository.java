package com.sharp6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sharp6.entity.user.LoginSession;
import com.sharp6.entity.user.UserMaster;

@Repository
public interface LoginRepository extends JpaRepository<LoginSession, String> {
	@Query(value = "SELECT * FROM login_session WHERE email = ?1 and password = ?2", nativeQuery = true)
	LoginSession userLogin(String emailAddress, String password);

	@Query(value = "update logouttime=?2 FROM login_session WHERE userId = ?1 ", nativeQuery = true)
	LoginSession userLogout(String userId, String logouttime);

	
}
