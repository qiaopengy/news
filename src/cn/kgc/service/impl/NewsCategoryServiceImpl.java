package cn.kgc.service.impl;

import cn.kgc.dao.NewsDao;
import cn.kgc.dao.News_categoryDao;
import cn.kgc.dao.impl.NewsDaoImpl;
import cn.kgc.dao.impl.News_categoryDaoImpl;
import cn.kgc.pojo.news_category;
import cn.kgc.service.NewsCategoryService;

public class NewsCategoryServiceImpl implements NewsCategoryService {

	private NewsDao newsDao;
	private News_categoryDao news_categoryDao;

	public NewsCategoryServiceImpl() {
		newsDao = new NewsDaoImpl();
		news_categoryDao = new News_categoryDaoImpl();
	}

	public boolean deleteNewsCategory(news_category news_category) {
		boolean flag = false;
		int count = newsDao.getCountByCategory(news_category);
		if (count > 0) {
			System.out.println("不能删除！该新闻分类下还有内容！");
		} else {
			flag = news_categoryDao.deleteNewsCategory(news_category);

		}
		return flag;
	}

}
