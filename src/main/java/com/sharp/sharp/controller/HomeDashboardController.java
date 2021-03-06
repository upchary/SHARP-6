package com.sharp.sharp.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharp.sharp.entity.Category;
import com.sharp.sharp.entity.Channel;
import com.sharp.sharp.entity.Contestdetails;
import com.sharp.sharp.entity.ShowDetails;
import com.sharp.sharp.entity.Status;
import com.sharp.sharp.entity.Teams;
import com.sharp.sharp.service.HomeDashBoardService;
import com.sharp.sharp.util.Constants;
import com.sharp.sharp.util.Sharp6Validation;

@RestController
@RequestMapping("/dashboard")
public class HomeDashboardController {
	private static final Logger logger = Logger.getLogger(HomeDashboardController.class);
	@Autowired
	private HomeDashBoardService dashBoardService;

	/**
	 * create categories
	 */
	@PostMapping("/category/")
	public Map<String, Object> createCategary(@RequestBody Category category) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Category resultObj = dashBoardService.addCategory(category);
		if (!Sharp6Validation.isEmpty(resultObj)) {
			logger.info("successs");
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", resultObj);

		} else {
			logger.error("error");
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "category adding failed");

		}
		return resultMap;

	}

	/**
	 * get categories
	 */
	@GetMapping("/Getcategory/")
	public Map<String, Object> getCategary() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Category> resultList = dashBoardService.getAllCategory();
		if (!Sharp6Validation.isEmpty(resultList)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", resultList);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "unable to fetch categories");
		}

		return resultMap;

	}

	/**
	 * get category by Id
	 */
	@PostMapping("/GetcategoryById/")
	public Map<String, Object> getCategaryById(@RequestBody Category category) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Optional<Category> resultList = dashBoardService.getCategoryBYId(category);
		if (!Sharp6Validation.isEmpty(resultList)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", resultList);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "unable to fetch category");
		}

		return resultMap;

	}

	@PostMapping("/createChannel/")
	public Map<String, Object> createChannel(@RequestBody Channel channel) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		channel.setChannelid(channel.getChannelname().toUpperCase());
		channel.setCreateddate(new Timestamp(System.currentTimeMillis()));
		Channel resultList = dashBoardService.createChannel(channel);
		if (!Sharp6Validation.isEmpty(resultList)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", resultList);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "unable to Create Channel");
		}

		return resultMap;

	}

	/**
	 * get categories
	 */
	@GetMapping("/GetChannels/")
	public Map<String, Object> getAllChannels() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Channel> resultList = dashBoardService.getAllChannels();
		if (!Sharp6Validation.isEmpty(resultList)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", resultList);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "unable to fetch Channels");
		}

		return resultMap;

	}

	/**
	 * get Channel by Id
	 */
	@PostMapping("/GetChannelById/")
	public Map<String, Object> getChannelById(@RequestBody Channel category) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Optional<Channel> resultList = dashBoardService.getChannelById(category);
		if (!Sharp6Validation.isEmpty(resultList)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", resultList);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "unable to fetch Channel");
		}

		return resultMap;

	}

	/**
	 * add show
	 */
	@PostMapping("/addShow/")
	public Map<String, Object> addShow(@RequestBody ShowDetails show) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		ShowDetails resultList = dashBoardService.crateShow(show);
		if (!Sharp6Validation.isEmpty(resultList)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", resultList);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "unable to create Show");
		}

		return resultMap;

	}

	/**
	 * get Shows
	 */
	@GetMapping("/GetALLShows/")
	public Map<String, Object> getAllShows() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object[]> resultList = dashBoardService.getAllShows();
		if (!Sharp6Validation.isEmpty(resultList)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", resultList);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "unable to fetch Shows");
		}

		return resultMap;

	}

	/**
	 * get Channel by Id
	 */
	@PostMapping("/GetShowById/")
	public Map<String, Object> getShowById(@RequestBody ShowDetails show) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Object resultList = dashBoardService.getShowById(show);
		if (!Sharp6Validation.isEmpty(resultList)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", resultList);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "unable to fetch Show");
		}

		return resultMap;
	}

	/**
	 * delete show by Id
	 */
	@PostMapping("/removeshowbyId/")
	public Map<String, Object> remooveShow(@RequestBody ShowDetails show) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String resultList = dashBoardService.deleteShow(show);
		if (!resultList.equals(Constants.SUCCESS)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", "Show Remooved Successfully");
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "unable to Remove Show");
		}

		return resultMap;

	}

	/**
	 * create contest
	 */
	@PostMapping("/createContest/")
	public Map<String, Object> createContest(@RequestBody Contestdetails contest) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		contest.setCreateddate(String.valueOf(new Timestamp(System.currentTimeMillis())));

		Status status = dashBoardService.saveStatus(contest);
		contest.setStatusid(status.getStatusid());
		Contestdetails resultList = dashBoardService.createCOntest(contest);
		if (!Sharp6Validation.isEmpty(resultList)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", resultList);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "unable to Create Contest");
		}

		return resultMap;

	}

	/**
	 * 
	 * getContestById
	 */
	@PostMapping("/contestById/")
	public Map<String, Object> getContestById(@RequestBody Contestdetails contest) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Contestdetails resultList = dashBoardService.getContestById(contest.getContestid());
		if (!Sharp6Validation.isEmpty(resultList)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", resultList);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "contest not Exist");
		}

		return resultMap;

	}

	/**
	 * 
	 * getContestById
	 */
	@GetMapping("/getAllContests/")
	public Map<String, Object> getAllContests() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Contestdetails> resultList = dashBoardService.getAllContests();
		if (!Sharp6Validation.isEmpty(resultList)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", resultList);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "contest not Exist");
		}

		return resultMap;

	}

	@PostMapping("/completeContest/")
	public Map<String, Object> completeContest(@RequestBody Contestdetails contest) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Contestdetails resultList = dashBoardService.updateContest(contest);
		if (!Sharp6Validation.isEmpty(resultList)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value1", "status updated successfuly");
			resultMap.put("value", resultList);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "unable to comlete the Contest");
		}

		return resultMap;

	}

	/**
	 * create contest
	 */
	@PostMapping("/createTeam/")
	public Map<String, Object> createTeams(@RequestBody Teams teams) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		teams.setCreateddate(new Timestamp(System.currentTimeMillis()));
		Teams teamList = dashBoardService.saveTeam(teams);

		if (!Sharp6Validation.isEmpty(teamList)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", teamList);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "unable to Create Team");
		}

		return resultMap;

	}

	@GetMapping("/getAllTeams/")
	public Map<String, Object> fetchTeams() {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<Teams> teamList = dashBoardService.getAllTeams();

		if (!Sharp6Validation.isEmpty(teamList)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", teamList);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("errorValue", "unable to Fetch Teams");
		}

		return resultMap;

	}

}
