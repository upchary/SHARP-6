package com.sharp.sharp.serviceImpl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sharp.sharp.entity.Category;
import com.sharp.sharp.entity.Channel;
import com.sharp.sharp.entity.Contestdetails;
import com.sharp.sharp.entity.ShowDetails;
import com.sharp.sharp.repository.CategoryRepository;
import com.sharp.sharp.repository.ChannelRepository;
import com.sharp.sharp.repository.ContestRepository;
import com.sharp.sharp.repository.ShowRepository;
import com.sharp.sharp.service.HomeDashBoardService;
import com.sharp.sharp.util.Constants;

@Component
@Transactional
public class HomeDashboardServiceImpl implements HomeDashBoardService {
	private static final Logger logger = Logger.getLogger(HomeDashboardServiceImpl.class);
	@Autowired
	private ShowRepository showDao;
	@Autowired
	private CategoryRepository categoryDao;
	@Autowired
	private ChannelRepository channelDao;
	@Autowired
	private ContestRepository contestDao;

	@Override
	public Category addCategory(Category cateory) {
		// TODO Auto-generated method stub
		try {

			logger.info("=============>");

			cateory.setCreateddate(new Timestamp(System.currentTimeMillis()));
			for (int i = 0; i < cateory.getSubcategory().size(); i++) {
				cateory.getSubcategory().get(i)
						.setSubcategoryid(cateory.getSubcategory().get(i).getSubcategoryname().toUpperCase());
				cateory.getSubcategory().get(i).setCreateddate(new Timestamp(System.currentTimeMillis()));

			}

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

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Category> getCategoryBYId(Category category) {
		try {

			Optional<Category> findById = categoryDao.findById(category.getCategoryid());

			logger.info("success");
			return findById;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("error at service implmentation");
			return null;

		}
	}

	@Override
	public Channel createChannel(Channel channel) {
		// TODO Auto-generated method stub
		try {
			Channel channelObj = channelDao.save(channel);
			return channelObj;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Channel> getAllChannels() {
		// TODO Auto-generated method stub
		try {
			List<Channel> findAll = channelDao.findAll();
			logger.info("success");
			return findAll;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("error at service implmentation");
			return null;

		}

	}

	@Override
	public Optional<Channel> getChannelById(Channel channel) {
		// TODO Auto-generated method stub
		try {

			Optional<Channel> findById = channelDao.findById(channel.getChannelid());

			logger.info("success");
			return findById;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("error at service implmentation");
			return null;

		}
	}

	@Override
	public ShowDetails crateShow(ShowDetails show) {
		// TODO Auto-generated method stub
		try {
			ShowDetails showObj = showDao.save(show);
			return showObj;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Object[]> getAllShows() {
		// TODO Auto-generated method stub
		List<Object[]> getallshows = showDao.getallshows();
		return getallshows;
	}

	@Override
	public Object getShowById(ShowDetails show) {
		// TODO Auto-generated method stub
		Object showdetailsById = showDao.getShowdetailsById(show.getShowid());
		
		return showdetailsById;
	}

	@Override
	public String deleteShow(ShowDetails show) {
		// TODO Auto-generated method stub

		try {

			showDao.deleteById(show.getShowid());
			return Constants.SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			return Constants.FAILURE;
		}
	}

	@Override
	public Contestdetails createCOntest(Contestdetails contest) {
		// TODO Auto-generated method stub
		try {
			Contestdetails contestobj = contestDao.save(contest);
			return contestobj;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public Contestdetails updateContest(Contestdetails contest) {
		// TODO Auto-generated method stub
		try {
			Contestdetails contestobj = contestDao.saveAndFlush(contest);
			return contestobj;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Contestdetails getContestById(String contestid) {
		// TODO Auto-generated method stub
		try {
			Contestdetails contest = contestDao.getById(contestid);
			return contest;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Contestdetails> getAllContests() {
		// TODO Auto-generated method stub
		try {
			List<Contestdetails> totalcontests = contestDao.findAll();
			return totalcontests;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
