<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="cn.kgc.service.NewsService"%>
<%@page import="cn.kgc.pojo.News_detail"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/common.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"> </script>
</head>
<body>

	<%
		//这里获得了要修改的新闻的id值,并将id值通过表单再次传递出去
		int id = Integer.parseInt(request.getParameter("id"));

		//根据id值在修改页面预先填充原有的内容
		News_detail news_detail = newsService.getNewsById(id);
	%>



	<form name="dataFrm" id="dataFrm" action="doModify.jsp?id=<%=id%>"
		method="post">
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<thead>
				<tr>
					<td align="center" colspan="2" class="text_tabledetail2">增加新闻</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="text-align:right;" class="text_tabledetail2">分类</td>
					<td style="text-align:left;">
						<!-- 列出所有的新闻分类 --> <select name="categoryId">
							<option value="1">国内</option>
							<option value="2">国际</option>
							<option value="3">娱乐</option>
							<option value="4">军事</option>
							<option value="5">财经</option>
							<option value="6">天气</option>
					</select>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;" class="text_tabledetail2">标题</td>
					<td style="text-align:left;"><input type="text" name="title"
						value="<%=news_detail.getTitle()%>" /></td>
				</tr>
				<tr>
					<td style="text-align:right;" class="text_tabledetail2">作者</td>
					<td style="text-align:left;"><input type="text" name="author"
						value="<%=news_detail.getAuthor()%>" /></td>
				</tr>

				<tr>
					<td style="text-align:right;" class="text_tabledetail2">摘要</td>
					<td style="text-align:left;"><textarea id="summary"
							name="summary" rows="8" cols="50">
							</textarea></td>
				</tr>
				<tr>
					<td style="text-align:right;" class="text_tabledetail2">内容</td>
					<td style="text-align:left;">
						<div id="xToolbar"></div> <textarea id="newscontent"
							name="newscontent" rows="8" cols="30" class="ckeditor"></textarea>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;" class="text_tabledetail2">上传图片</td>
					<td style="text-align:left;"><input type="file" name="picPath"
						value="<%=news_detail.getPicPath()%>" /></td>
				</tr>
				<tr>
					<td style="text-align:center;" colspan="2">
						<button type="submit" class="page-btn" name="save">保存</button>
						<button type="button" class="page-btn" name="return"
							onclick="javascript:location.href='newsDetailList.jsp'">返回</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>

<script>
	document.getElementById("summary").value = "<%=news_detail.getSummary()%>"
	document.getElementById("newscontent").value = "<%=news_detail.getContent()%>"
</script>