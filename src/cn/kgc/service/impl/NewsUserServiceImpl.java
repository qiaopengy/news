package cn.kgc.service.impl;

import cn.kgc.dao.UserDao;
import cn.kgc.dao.impl.UserDaoImpl;
import cn.kgc.pojo.News_user;
import cn.kgc.service.NewsUserService;

public class NewsUserServiceImpl implements NewsUserService {
	UserDao userDao = new UserDaoImpl();

	public boolean login(News_user news_user) {
		return userDao.login(news_user);
	}

}
