package com.sharp.sharp.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sharp.sharp.entity.ImagesEntity;
import com.sharp.sharp.service.ImageUploadService;
import com.sharp.sharp.util.Constants;
import com.sharp.sharp.util.Sharp6Validation;

@RestController
public class ImageUploadController {
	@Autowired
	private ImageUploadService ImageService;

	@PostMapping("/getAllImagesById/")
	public HashMap<String, Object> uploadImage(@RequestBody ImagesEntity file) {
		HashMap<String, Object> resultMap = new HashMap<>();
		List<ImagesEntity> allImagesById = ImageService.getAllImagesById(file.getUserId());
		if (Sharp6Validation.isEmpty(allImagesById)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", allImagesById);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("value", "No Images Are available");
		}
		return resultMap;
	}

	@PostMapping("/uploadFile/")
	public ImagesEntity uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("userId") String userId)
			throws IOException {

		ImagesEntity entity = new ImagesEntity();
		entity.setUserId(userId);
		entity.setId(String.valueOf(System.currentTimeMillis()));
		entity.setFileName(file.getName());
		entity.setData(file.getBytes());
		ImagesEntity dbFile = ImageService.upoadImages(entity);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(dbFile.getId()).toUriString();

		return new ImagesEntity(dbFile.getUserId(), file.getName(), file.getContentType(), file.getSize(),
				fileDownloadUri);
	}

}
