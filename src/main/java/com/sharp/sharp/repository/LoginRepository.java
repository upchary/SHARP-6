package com.sharp.sharp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sharp.sharp.entity.LoginSession;

@Repository
public interface LoginRepository extends JpaRepository<LoginSession, String> {

	@Query(value = "update logouttime=?2 FROM login_session WHERE userId = ?1 ", nativeQuery = true)
	LoginSession userLogout(String userId, String logouttime);
}
