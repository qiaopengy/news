package cn.kgc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.kgc.util.ConfigManager;

//数据库操作的基类
public class BaseDao {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;

	// 获取数据库连接
	public boolean getConnection() {

		try {
			Class.forName(ConfigManager.getInstence().getString("jdbc.driver"));
			String url = ConfigManager.getInstence().getString("jdbc.connection.url");
			String username = ConfigManager.getInstence().getString("jdbc.connection.username");
			String password = ConfigManager.getInstence().getString("jdbc.connection.password");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 获取数据库连接(数据源方式)
	public boolean getConnection2() {
		try {
			// 初始一个上下文对象
			Context context = new InitialContext();
			// 获取到与逻辑名称相关联的数据源对象

			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/news");

			// 通过数据源来获取数据库连接
			connection = dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	// 增删改
	public int executeUpdate(String sql, Object[] params) {

		int updateRows = 0;// 受影响的行数

		// 如果当前类中的链接方法成功
		if (this.getConnection()) {
			try {

				// 执行sql语句参数
				pstmt = connection.prepareStatement(sql);

				// 填充占位符
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}

				// 此方法返回一个int值，表示受到影响的行数,用之前川江的变量接收
				updateRows = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return updateRows;
	}

	// 查询
	public ResultSet executeQuery(String sql, Object[] params) {

		if (this.getConnection()) {
			try {
				pstmt = connection.prepareStatement(sql);

				// 填充占位符
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
				resultSet = pstmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultSet;
	}
	// 查询:通过数据源
	public ResultSet executeQuery2(String sql, Object[] params) {
		
		if (this.getConnection2()) {
			try {
				pstmt = connection.prepareStatement(sql);
				
				// 填充占位符
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
				resultSet = pstmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultSet;
	}

	// 释放资源
	public boolean closeResource() {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
