package cn.kgc.dao;

import java.util.List;

import cn.kgc.pojo.News_detail;
import cn.kgc.pojo.news_category;
/*使用JDBC实现课工场数据的增删改查*/

public interface NewsDao {
	// 通过数据源获取连接，进行数据库操作，查询新闻
	public void getNewsListByDS();

	// 获取数据库链连接方法
	public boolean getConnection();

	// 增加新闻信息的方法
	public boolean addNews(News_detail news_detail);

	// 删除特定新闻的方法
	public boolean deleteNews(News_detail news_detail);

	// 修改特定新闻标题的方法
	public boolean updateNews(News_detail news_detail);

	// 查询全部新闻信息的方法

	public List<News_detail> getNewsList();

	// 查询特定标题的新闻信息
	// 使用 PreparedStatement
	public void getNewsByTitle(News_detail news_detail);

	// 查询某个标题分类下是否有新闻内容
	public int getCountByCategory(news_category news_category);

	// 根据id查询特定新闻信息
	public News_detail getNewsById(int id);

	// 获取新闻总数量
	public int getTotalCount();

	// 分页获取新闻数据，pageNo是当前页码，pageSize是页面容量
	public List<News_detail> getPageNewsList(int pageNo, int pageSize);

}
