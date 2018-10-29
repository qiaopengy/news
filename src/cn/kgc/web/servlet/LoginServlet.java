package cn.kgc.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.pojo.News_user;
import cn.kgc.service.NewsUserService;
import cn.kgc.service.impl.NewsUserServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userCode = request.getParameter("userCode");
		String userPassword = request.getParameter("userPassword");

		News_user news_user = new News_user();
		news_user.setUserName(userCode);
		news_user.setPassword(userPassword);

		NewsUserService newsUserService = new NewsUserServiceImpl();

		// 调用userService的方法，根据用户名和密码去数据库查询是否有该用户
		boolean flag = newsUserService.login(news_user);

		if (flag) {
			request.getSession().setAttribute("user", news_user);
			response.sendRedirect(request.getContextPath() + "/jsp/admin/admin.jsp");
		} else {
			// 登陆失败
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
		}

	}

}
