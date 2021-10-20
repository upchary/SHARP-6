package com.sharp.sharp.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageUploadController {

	@PostMapping("/uploadImages/")
	public HashMap<String, Object> uploadImage() {
		HashMap<String, Object> resultMap = new HashMap<>();

		return resultMap;
	}

}
