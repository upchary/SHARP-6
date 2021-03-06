package com.sharp.sharp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sharp.sharp.entity.Category;
import com.sharp.sharp.entity.Channel;
import com.sharp.sharp.entity.Contestdetails;
import com.sharp.sharp.entity.ShowDetails;
import com.sharp.sharp.entity.Status;
import com.sharp.sharp.entity.Teams;

@Service
@Transactional
public interface HomeDashBoardService {
	Category addCategory(Category category);

	List<Category> getAllCategory();

	Optional<Category> getCategoryBYId(Category category);

	Channel createChannel(Channel category);

	List<Channel> getAllChannels();

	Optional<Channel> getChannelById(Channel category);

	ShowDetails crateShow(ShowDetails show);

	List<Object[]> getAllShows();

	Object getShowById(ShowDetails show);

	String deleteShow(ShowDetails show);

	Contestdetails createCOntest(Contestdetails contest);

	Contestdetails updateContest(Contestdetails contest);

	Contestdetails getContestById(String contestid);

	List<Contestdetails> getAllContests();

	Teams saveTeam(Teams teams);

	Status saveStatus(Contestdetails contest);

	List<Teams> getAllTeams();

}
