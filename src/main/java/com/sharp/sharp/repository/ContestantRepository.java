package com.sharp.sharp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharp.sharp.entity.ContestastantsEntity;

@Repository
public interface ContestantRepository extends JpaRepository<ContestastantsEntity, Integer> {

}
