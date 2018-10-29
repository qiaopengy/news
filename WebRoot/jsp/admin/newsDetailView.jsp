<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="cn.kgc.pojo.News_detail"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/common.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"> </script>
</head>
<body>

	<%
		//获取传递来的id值
		int id = Integer.parseInt(request.getParameter("id"));

		//调用后台方法根据id查询新闻
		News_detail news_detail = newsService.getNewsById(id);

		request.setAttribute("news_detail", news_detail);
	%>


	<div class="main-content-right">

		<div class="main-text-box">
			<div class="main-text-box-tbg">
				<div class="main-text-box-bbg">
					<div class="article-box">
						<!--新闻的标题-->
						<h1><c:out value = "${news_detail.title}" escapeXml="true"/></h1>
						<div class="source-bar">
							发布者：${news_detail.author}
							分类：新闻信息 更新时间：<fmt:formatDate value="${news_detail.createDate}" pattern="yyyy-MM-dd" />
						</div>
						<div class="article-content">
							<span class="article-summary"><b>摘要：${news_detail.summary}</b></span>
							<%
								if (news_detail.getPicPath() == null || news_detail.getPicPath().equals("")) {
							%>

							新闻图片：暂无<br />
							<%
								} else {
							%>
							<img
								src="<%=request.getContextPath()%>/upload/<%=news_detail.getPicPath()%>" />
							<%
								}
							%>
							${news_detail.content}

						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>