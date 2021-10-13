package com.sharp6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sharp6.entity.user.LoginSession;
import com.sharp6.entity.user.UserMaster;

@Repository
public interface UserRepositoryy extends JpaRepository<UserMaster, Integer> {

	@Query(value = "SELECT * FROM user_master WHERE email = ?1 and password = ?2 and activestatus=1", nativeQuery = true)
	UserMaster getUser(String emailAddress, String password);

	@Query(value = "update password=?2 FROM login_session WHERE userId = ?1 ", nativeQuery = true)
	UserMaster changePassword(String userId, String password);
}
