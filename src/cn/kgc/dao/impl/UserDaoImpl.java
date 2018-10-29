package cn.kgc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.kgc.dao.BaseDao;
import cn.kgc.dao.UserDao;
import cn.kgc.pojo.News_user;

public class UserDaoImpl extends BaseDao implements UserDao {

	public boolean login(News_user news_user) {
		boolean flag = false;
		try {
			String sql = "SELECT COUNT(1) FROM news_user WHERE userName = ? AND password = ?";
			Object[] params = { news_user.getUserName(), news_user.getPassword() };

			ResultSet resultSet = this.executeQuery(sql, params);
			while (resultSet.next()) {
				int i = resultSet.getInt(1);
				if (i == 1) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}
}
