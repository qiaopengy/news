<%@page import="cn.kgc.service.impl.NewsServiceImpl"%>
<%@page import="cn.kgc.service.NewsService"%>
<%@page import="cn.kgc.pojo.News_detail"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'doModify.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>

	<%
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));

		News_detail news_detail = new News_detail();
		NewsService newsService = new NewsServiceImpl();

		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String summary = request.getParameter("summary");
		String newscontent = request.getParameter("newscontent");
		String picPath = request.getParameter("picPath");

		news_detail.setCategoryId(categoryId);
		news_detail.setTitle(title);
		news_detail.setAuthor(author);
		news_detail.setSummary(summary);
		news_detail.setContent(newscontent);
		news_detail.setPicPath(picPath);
		news_detail.setId(id);

		boolean flag = newsService.updateNews(news_detail);
		if (flag) {
	%>
	<jsp:forward page="newsDetailList.jsp"></jsp:forward>

	<%
		} else {
	%>
	<jsp:forward page="newsModify.jsp"></jsp:forward>
	<%
		}
	%>


</body>
</html>
