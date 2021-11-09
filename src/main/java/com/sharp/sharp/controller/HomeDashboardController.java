package com.sharp.sharp.controller;

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
	public Map<String, Object> createChannel(@RequestBody Channel category) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Channel resultList = dashBoardService.createChannel(category);
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
}
