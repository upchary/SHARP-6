package com.sharp.sharp.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sharp.sharp.entity.ImagesEntity;
import com.sharp.sharp.service.ImageUploadService;
import com.sharp.sharp.util.Sharp6Validation;

@RestController
public class ImageUploadController {
	@Autowired
	private ImageUploadService ImageService;

	@PostMapping("/uploadImages/")
	public HashMap<String, Object> uploadImage(@RequestBody MultipartFile file) {
		HashMap<String, Object> resultMap = new HashMap<>();

		return resultMap;
	}

	@PostMapping(value = "/multiple-file-upload")
	public String uploadMultipleFiles(@RequestParam("myFiles") MultipartFile[] multipartFiles) throws IOException {
		String status = null;
		for (MultipartFile multipartFile : multipartFiles) {
			multipartFile.transferTo(new File("F:\\" + multipartFile.getOriginalFilename()));
			ImagesEntity entity = new ImagesEntity();
			// entity.setImage(multipartFile);
			ImagesEntity upoadImages = ImageService.upoadImages(entity);
			if (!Sharp6Validation.isEmpty(upoadImages)) {
				status = "success";
			}

		}
		return status;
	}

	@PostMapping("/uploadFile")
	public ImagesEntity uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

		ImagesEntity entity = new ImagesEntity();
		entity.setId(String.valueOf(System.currentTimeMillis()));
		entity.setFileName(file.getName());
		entity.setData(file.getBytes());
		ImagesEntity dbFile = ImageService.upoadImages(entity);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(dbFile.getId()).toUriString();

		return new ImagesEntity(dbFile.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
	}
}
