package cn.kgc.dao.impl;

import cn.kgc.dao.BaseDao;
import cn.kgc.dao.News_categoryDao;
import cn.kgc.pojo.news_category;

public class News_categoryDaoImpl extends BaseDao implements News_categoryDao {

	// 删除删除某个新闻类别
	public boolean deleteNewsCategory(news_category news_categoryId) {
		boolean flag = false;
		String sql = "delete from news_category where id=?";
		Object[] params = { news_categoryId.getId() };
		int i = this.executeUpdate(sql, params);
		if (i > 0) {
			System.out.println("删除新闻类别成功");
			flag = true;
		}
		this.closeResource();
		return flag;
	}

}
