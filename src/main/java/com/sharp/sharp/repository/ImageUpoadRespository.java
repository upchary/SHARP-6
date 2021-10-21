package com.sharp.sharp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharp.sharp.entity.ImagesEntity;

@Repository
public interface ImageUpoadRespository extends JpaRepository<ImagesEntity, Integer> {

}
