package com.sharp.sharp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sharp.sharp.entity.Language;
import com.sharp.sharp.entity.UserMaster;

@Repository
public interface UserRepository extends JpaRepository<UserMaster, String> {

	@Query(value = "SELECT * FROM users WHERE userid = ?1", nativeQuery = true)
	UserMaster getUser(String emailAddress, String password);

	@Query(value = "SELECT * FROM users WHERE userid = ?1", nativeQuery = true)
	UserMaster userLogin(String emailAddress, String password);

	@Query(value = "update password=?2 FROM users WHERE userid = ?1 ", nativeQuery = true)
	UserMaster changePassword(String userId, String password);

	@Query(value = "SELECT * FROM language", nativeQuery = true)
	List<Object[]> getALLLanguages();
}
