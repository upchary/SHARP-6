package com.sharp.sharp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sharp.sharp.entity.ImagesEntity;

@Repository
public interface ImageUpoadRespository extends JpaRepository<ImagesEntity, Integer> {

	@Query(value = "SELECT * FROM ImagesEntity WHERE userId = ?1 ", nativeQuery = true)
	List<ImagesEntity> findAllById(String userId);

}
