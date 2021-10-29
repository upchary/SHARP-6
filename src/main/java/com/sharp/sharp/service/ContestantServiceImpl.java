package com.sharp.sharp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sharp.sharp.controller.ContestantController;
import com.sharp.sharp.entity.ContestastantsEntity;
import com.sharp.sharp.repository.ContestantRepository;

@Component
@Transactional
public class ContestantServiceImpl implements ContestatantService {

	@Autowired
	ContestantRepository contestantDao;

	@Override
	public List<ContestastantsEntity> createNewContestant(List<ContestastantsEntity> contestnts) {
		ArrayList<ContestastantsEntity> list = new ArrayList<>();
		try {
			for (ContestastantsEntity contestantController : contestnts) {

				ContestastantsEntity contestant = contestantDao.save(contestantController);
				list.add(contestant);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return list;
		}

		return list;
	}

}
