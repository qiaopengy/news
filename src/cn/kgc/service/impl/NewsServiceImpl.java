package cn.kgc.service.impl;

import java.util.List;

import cn.kgc.dao.NewsDao;
import cn.kgc.dao.impl.NewsDaoImpl;
import cn.kgc.pojo.News_detail;
import cn.kgc.service.NewsService;

public class NewsServiceImpl implements NewsService {

	private NewsDao newsDao;

	public NewsServiceImpl() {
		newsDao = new NewsDaoImpl();
	}

	public List<News_detail> getNewsList() {

		return newsDao.getNewsList();
	}

	public boolean addNews(News_detail news_detail) {

		return newsDao.addNews(news_detail);

	}

	public News_detail getNewsById(int id) {

		return newsDao.getNewsById(id);
	}

	public boolean deleteNews(News_detail news_detail) {
		return newsDao.deleteNews(news_detail);
	}

	public boolean updateNews(News_detail news_detail) {
		return newsDao.updateNews(news_detail);
	}

	public int getTotalCount() {
		return newsDao.getTotalCount();
	}

	public List<News_detail> getPageNewsList(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return newsDao.getPageNewsList(pageNo, pageSize);
	}

}
