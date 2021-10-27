package com.sharp.sharp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sharp.sharp.entity.ImagesEntity;
import com.sharp.sharp.repository.ImageUpoadRespository;
import com.sharp.sharp.service.ImageUploadService;

@Component
@Transactional
public class ImagesUploadserviceImpl implements ImageUploadService {

	@Autowired
	private ImageUpoadRespository imageDao;

	@Override
	public ImagesEntity upoadImages(ImagesEntity images) {
		// TODO Auto-generated method stub
		ImagesEntity savedImages = new ImagesEntity();
		try {
			savedImages = imageDao.save(images);
		} catch (Exception e) {
			// TODO: handle exception
			savedImages = null;
		}
		return savedImages;
	}

	@Override
	public List<ImagesEntity> getAllImagesById(String userId) {
		// TODO Auto-generated method stub
		try {
			List<ImagesEntity> findAllById = imageDao.findAllById(userId);
			return findAllById;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

}
