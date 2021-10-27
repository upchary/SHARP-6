package com.sharp.sharp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sharp.sharp.entity.ImagesEntity;

@Service
@Transactional
public interface ImageUploadService {

	ImagesEntity upoadImages(ImagesEntity images);

	List<ImagesEntity> getAllImagesById(String userId);
}
