package com.sharp.sharp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sharp.sharp.entity.Category;
import com.sharp.sharp.entity.Channel;

@Service
@Transactional
public interface HomeDashBoardService {
	Category addCategory(Category category);

	List<Category> getAllCategory();

	Optional<Category> getCategoryBYId(Category category);

	Channel createChannel(Channel category);

	List<Channel> getAllChannels();

	Optional<Channel> getChannelById(Channel category);

}
