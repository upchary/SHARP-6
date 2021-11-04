package com.sharp.sharp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharp.sharp.entity.Category;
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
	@PostMapping("/category")
	public Map<String, Object> createCategary(@RequestBody Category category) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Category resultObj = dashBoardService.addCategory(category);
		if (Sharp6Validation.isEmpty(resultObj)) {
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
	@GetMapping("/Getcategory")
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

}
