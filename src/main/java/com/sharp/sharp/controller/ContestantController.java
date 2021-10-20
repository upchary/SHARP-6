package com.sharp.sharp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.language.bm.Languages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sharp.sharp.util.Constants;

@RestController
public class ContestantController {
	@PostMapping("/addContestant/")
	public HashMap<String, Object> addContestant() {
		HashMap<String, Object> resultMap = new HashMap<>();

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
			List<Languages> langList =null;//logic gere

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
