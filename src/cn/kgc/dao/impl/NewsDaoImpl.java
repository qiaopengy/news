package cn.kgc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
/*使用JDBC实现课工场数据的增删改查*/
import java.util.List;

import org.omg.CORBA.DATA_CONVERSION;

import cn.kgc.dao.BaseDao;
import cn.kgc.dao.NewsDao;
import cn.kgc.pojo.News_detail;
import cn.kgc.pojo.news_category;

public class NewsDaoImpl extends BaseDao implements NewsDao {

	// 获取新闻总数量
	public int getTotalCount() {
		int total = 0;
		String sql = "SELECT count(1) FROM news_detail";
		Object[] params = {};
		ResultSet resultSet = this.executeQuery(sql, params);
		try {
			while (resultSet.next()) {

				total = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	// 分页获取新闻数据,pageNo是当前页码，pageSize是页面容量
	public List<News_detail> getPageNewsList(int pageNo, int pageSize) {

		List<News_detail> list = new ArrayList<News_detail>();

		String sql = "SELECT id,title,author,createDate FROM news_detail  order by createDate desc LIMIT ?,?";
		Object[] params = { (pageNo - 1) * pageSize, pageSize };

		ResultSet resultSet = this.executeQuery(sql, params);

		// 遍历结果集
		try {
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String getTitle = resultSet.getString("title");
				String author = resultSet.getString("author");
				Timestamp createDate = resultSet.getTimestamp("createDate");

				News_detail news_detail = new News_detail();
				news_detail.setId(id);
				news_detail.setTitle(getTitle);
				news_detail.setAuthor(author);
				news_detail.setCreateDate(createDate);

				list.add(news_detail);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	

	// 增加新闻信息的方法
	public boolean addNews(News_detail news_detail) {
		boolean flag = false;
		try {
			this.getConnection();
			// 编写sql语句
			String sql = "INSERT INTO news_detail(categoryId,title,summary,content,author,createdate,picpath) VALUES(?,?,?,?,?,?,?)";
			// 创建object数组，放入占位符对应的语句信息
			Object[] params = { news_detail.getCategoryId(), news_detail.getTitle(), news_detail.getSummary(),
					news_detail.getContent(), news_detail.getAuthor(), news_detail.getCreateDate(),
					news_detail.getPicPath() };
			// 继承来的方法
			int i = this.executeUpdate(sql, params);
			// 只要返回的受影响的行数>0，说明update成功
			if (i > 0) {
				flag = true;
			}
		} finally {
			// 继承来的方法
			this.closeResource();
		}
		return flag;
	}

	// 删除特定新闻的方法
	public boolean deleteNews(News_detail news_detail) {
		boolean flag = false;
		try {
			this.getConnection();
			String sql = "DELETE FROM news_detail WHERE id=?";
			Object[] params = { news_detail.getId() };
			int i = this.executeUpdate(sql, params);
			if (i > 0) {
				flag = true;
			}
		} finally {
			this.closeResource();
		}
		return flag;
	}

	// 修改特定新闻标题的方法
	public boolean updateNews(News_detail news_detail) {
		boolean flag = false;
		try {
			this.getConnection();
			String sql = "UPDATE news_detail SET categoryid=?,title=?,author=?,summary=?,content=?,picPath=? WHERE id=?";
			Object[] params = { news_detail.getCategoryId(), news_detail.getTitle(), news_detail.getAuthor(),
					news_detail.getSummary(), news_detail.getContent(), news_detail.getPicPath(), news_detail.getId() };
			int i = this.executeUpdate(sql, params);
			if (i > 0) {
				flag = true;
			}
		} finally {
			this.closeResource();
		}
		return flag;
	}

	// 查询全部新闻信息的方法

	public List<News_detail> getNewsList() {

		List<News_detail> list = new ArrayList<News_detail>();

		try {
			this.getConnection();
			// 创建sql语句
			String sql = "SELECT id,categoryid,title,summary,content,author,createDate FROM news_detail";
			// 这里是查询表所有内容，因此没有占位符产生，数组还是要创建的，只是为空。
			Object[] params = {};
			// 创建结果集接收继承来的查询方法返回的结果
			ResultSet resultSet = this.executeQuery(sql, params);

			// 遍历结果集
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int categoryid = resultSet.getInt("categoryid");
				String getTitle = resultSet.getString("title");
				String summary = resultSet.getString("summary");
				String content = resultSet.getString("content");
				String author = resultSet.getString("author");
				Timestamp creattime = resultSet.getTimestamp("createDate");

				News_detail news_detail = new News_detail();
				news_detail.setId(id);
				news_detail.setCategoryId(categoryid);
				news_detail.setTitle(getTitle);
				news_detail.setSummary(summary);
				news_detail.setContent(content);
				news_detail.setAuthor(author);
				news_detail.setCreateDate(creattime);

				list.add(news_detail);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
		return list;
	}

	// 查询特定标题的新闻信息
	// 使用 PreparedStatement
	public void getNewsByTitle(News_detail news_detail) {

		try {

			String sql = "select id,title from news_detail where title =?";
			Object[] params = { news_detail.getTitle() };
			ResultSet resultSet = this.executeQuery(sql, params);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String getTitle = resultSet.getString("title");
				System.out.println(id + "\t" + getTitle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
	}

	public void getNewsListByDS() {
		try {
			// 创建sql语句
			String sql = "SELECT id,categoryid,title,summary,content,author,createDate FROM news_detail";
			// 这里是查询表所有内容，因此没有占位符产生，数组还是要创建的，只是为空。
			Object[] params = {};
			// 创建结果集接收继承来的查询方法返回的结果
			ResultSet resultSet = this.executeQuery2(sql, params);

			// 遍历结果集
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int categoryid = resultSet.getInt("categoryid");
				String getTitle = resultSet.getString("title");
				String summary = resultSet.getString("summary");
				String content = resultSet.getString("content");
				String author = resultSet.getString("author");

				// 时间date类型用TimeStam对象接收
				Timestamp creattime = resultSet.getTimestamp("createDate");
				System.out.println(id + "\t" + categoryid + "\t" + getTitle + "\t" + summary + "\t" + content + "\t"
						+ author + "\t" + creattime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
	}

	public int getCountByCategory(news_category news_category) {
		int count = 0;
		String sql = "SELECT COUNT(1) FROM news_detail WHERE categoryId = ?";
		Object[] params = { news_category.getId() };
		ResultSet resultSet = this.executeQuery(sql, params);
		try {
			while (resultSet.next()) {
				count = resultSet.getInt(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public News_detail getNewsById(int id) {
		News_detail news_detail = new News_detail();
		String sql = "select title,summary,author,content,createDate,picpath from news_detail where id = ?";
		Object[] params = { id };
		ResultSet resultSet = this.executeQuery(sql, params);
		try {
			while (resultSet.next()) {
				String title = resultSet.getString("title");
				String summary = resultSet.getString("summary");
				String author = resultSet.getString("author");
				String content = resultSet.getString("content");
				Timestamp createDate = resultSet.getTimestamp("createDate");
				String picpath = resultSet.getString("picpath");

				news_detail.setTitle(title);
				news_detail.setSummary(summary);
				news_detail.setAuthor(author);
				news_detail.setContent(content);
				news_detail.setCreateDate(createDate);
				news_detail.setPicPath(picpath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news_detail;
	}

	public static void main(String[] args) {
		NewsDao newsDao = new NewsDaoImpl();

		// News_detail news_detail_test = new News_detail();
		// news_detail_test.setId(88);
		// news_detail_test.setCategoryId(2);
		// news_detail_test.setTitle("test");
		// news_detail_test.setSummary("test");
		// news_detail_test.setContent("testcontent");
		// news_detail_test.setAuthor("admin");
		// news_detail_test.setCreateDate(new Date());
		//
		// newsDao.addNews(news_detail_test);

		newsDao.getNewsList();

		// newsDao.getNewsByTitle("Java Web开课啦");

		// newsDao.addNews(3, 1, "test", "test", "test", "superman", new
		// Date());

		/*
		 * News_detail news_detail_test = new News_detail();
		 * news_detail_test.setId(88); news_detail_test.setTitle("newtest");
		 * newsDao.updateNews(news_detail_test);
		 */

		// News_detail news_detail_test = new News_detail();
		// news_detail_test.setId(88);
		// newsDao.deleteNews(news_detail_test);

		// newsDao.getNewsListByDS();

		// newsDao.updateNews(3, "newTitle");
		// newsDao.deleteNews(3);
	}
}
