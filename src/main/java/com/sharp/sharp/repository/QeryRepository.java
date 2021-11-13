package com.sharp.sharp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharp.sharp.entity.Questions;

@Repository
public interface QeryRepository extends JpaRepository<Questions, String>{

}
