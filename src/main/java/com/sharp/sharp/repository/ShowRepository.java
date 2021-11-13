package com.sharp.sharp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharp.sharp.entity.ShowDetails;

@Repository
public interface ShowRepository extends JpaRepository<ShowDetails, String> {

}
