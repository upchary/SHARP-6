package com.sharp.sharp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.language.bm.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sharp.sharp.entity.ContestastantsEntity;
import com.sharp.sharp.service.ContestatantService;
import com.sharp.sharp.util.Constants;
import com.sharp.sharp.util.Sharp6Validation;

@RestController
public class ContestantController {
	@Autowired
	ContestatantService contestantService;

	@PostMapping("/addContestant/")
	public HashMap<String, Object> addContestant(@RequestBody List<ContestastantsEntity> contestnts) {
		HashMap<String, Object> resultMap = new HashMap<>();
		List<ContestastantsEntity> resultObj = contestantService.createNewContestant(contestnts);
		if (!Sharp6Validation.isEmpty(resultObj)) {
			resultMap.put("status", Constants.SUCCESS);
			resultMap.put("value", resultObj);
		} else {
			resultMap.put("status", Constants.FAILURE);
			resultMap.put("value", "No contestants were Added");
		}
		return resultMap;

	}

	@PostMapping("/categorisList/")
	public HashMap<String, Object> getcategorisList() {
		HashMap<String, Object> resultMap = new HashMap<>();

		return resultMap;

	}

	@RequestMapping(value = "/getAllLanguages/", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getLanguages() {
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put(Constants.URLPATH, "getAllLanguages");
		try {
			List<Languages> langList = null;// logic gere

			if (langList.size() > 0) {
				resultMap.put("status", Constants.SUCCESS);
				resultMap.put("value", langList);
			}
		} catch (Exception e) {
			resultMap.put("status", Constants.FAILURE);
			resultMap.put("errormessage", e.getMessage());
			resultMap.put("errorvalue", e.getLocalizedMessage());
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}

}
