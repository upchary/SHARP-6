package com.sharp.sharp.serviceImpl;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sharp.sharp.entity.Category;
import com.sharp.sharp.repository.CategoryRepository;
import com.sharp.sharp.service.HomeDashBoardService;

@Component
@Transactional
public class HomeDashboardServiceImpl implements HomeDashBoardService {
	private static final Logger logger = Logger.getLogger(HomeDashboardServiceImpl.class);
	@Autowired
	private CategoryRepository categoryDao;

	@Override
	public Category addCategory(Category cateory) {
		// TODO Auto-generated method stub
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			cateory.setCategoryid(String.valueOf(timestamp));
			cateory.setCreateddate(new Timestamp(System.currentTimeMillis()));
			cateory.getSubcategoryid().setSubcategoryid(cateory.getSubcategoryid().getSubcategoryname().toUpperCase());
			cateory.getSubcategoryid().setCreateddate(new Timestamp(System.currentTimeMillis()));

			Category obj = categoryDao.save(cateory);
			logger.info("success");
			return obj;
		} catch (Exception e) {
			logger.info("error at service implmentation");
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		try {
			List<Category> findAll = categoryDao.findAll();
			logger.info("success");
			return findAll;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("error at service implmentation");
			return null;

		}
	}

}
