package cn.kgc.dao;

import cn.kgc.pojo.news_category;

//操作新闻类别的一个接口
public interface News_categoryDao {

	//删除某个新闻类别
	public boolean deleteNewsCategory(news_category news_categoryId);
}
