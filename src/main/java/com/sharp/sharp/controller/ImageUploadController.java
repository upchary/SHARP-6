package com.sharp.sharp.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sharp.sharp.entity.ImagesEntity;

@RestController
public class ImageUploadController {

	@PostMapping("/uploadImages/")
	public HashMap<String, Object> uploadImage(@RequestBody ImagesEntity images) {
		HashMap<String, Object> resultMap = new HashMap<>();

		return resultMap;
	}

}
