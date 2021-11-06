package com.sharp.sharp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sharp.sharp.entity.Category;

@Service
@Transactional
public interface HomeDashBoardService {
	Category addCategory(Category category);

	List<Category> getAllCategory();

	Category getCategoryBYId(Category category);

}
