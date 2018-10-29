package cn.kgc.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.pojo.News_detail;
import cn.kgc.service.NewsService;
import cn.kgc.service.impl.NewsServiceImpl;

public class deleteServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		News_detail news_detail = new News_detail();
		NewsService newsService = new NewsServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		news_detail.setId(id);

	 newsService.deleteNews(news_detail);

		response.sendRedirect("/news/jsp/admin/newsDetailList.jsp");
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
