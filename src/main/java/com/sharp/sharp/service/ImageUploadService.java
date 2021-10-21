package com.sharp.sharp.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sharp.sharp.entity.ImagesEntity;

@Service
@Transactional
public interface ImageUploadService {

	ImagesEntity upoadImages(ImagesEntity images);
}
