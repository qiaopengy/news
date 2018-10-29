package cn.kgc.service;

import java.util.List;

import cn.kgc.pojo.News_detail;

//对新闻信息进行逻辑操作的接口
public interface NewsService {
	
	// 获取新闻总数量
	public int getTotalCount();

	// 分页获取新闻数据，pageNO是当前页码，pageSize是页面容量
	public List<News_detail> getPageNewsList(int pageNo,int pageSize);
	
	
	//查询全部信息
	public List<News_detail> getNewsList();
	
	//增加新闻方法
	
	public boolean addNews(News_detail news_detail);
	
	//根据id查询特定新闻信息
	
		public News_detail getNewsById(int id);
		
		public boolean deleteNews(News_detail news_detail);
		
		public boolean updateNews(News_detail news_detail);
	
}
