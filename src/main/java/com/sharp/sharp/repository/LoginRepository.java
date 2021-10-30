package com.sharp.sharp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sharp.sharp.entity.LoginSession;

@Repository
public interface LoginRepository extends JpaRepository<LoginSession, String> {

	@Query(value = "UPDATE myapplication.dbo.login_session SET 	logouttime=?2  WHERE user_id =?1 ", nativeQuery = true)
	void userLogout(String userId, String logouttime);

}
