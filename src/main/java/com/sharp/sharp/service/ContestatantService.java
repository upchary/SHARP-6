package com.sharp.sharp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sharp.sharp.entity.ContestastantsEntity;

@Service
public interface ContestatantService {

	List<ContestastantsEntity> createNewContestant(List<ContestastantsEntity> contestnts);

}
