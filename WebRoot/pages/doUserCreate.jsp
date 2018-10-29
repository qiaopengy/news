<%@page
	import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@page import="java.net.URLEncoder"%>
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

<title>My JSP 'doUserCreate.jsp' starting page</title>

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
		//request.setCharacterEncoding("utf-8");
		//response.setCharacterEncoding("utf-8");
		//获取用户名字符串
		String userName = request.getParameter("username");

		session.setAttribute("username", userName);
		
		String pwd = request.getParameter("password");
		String rpwd = request.getParameter("con_password");
		String email = request.getParameter("email");
		String[] hobbys = request.getParameterValues("hobby");
	%>

	<%
		if (userName.equals("admin") || userName == null || userName.length() == 0) {
			//不能是admin
			//用户注册失败，重新跳转回注册的页面（使用转发方式）
			request.setAttribute("mess", "注册失败！");
			request.getRequestDispatcher("userCreate.jsp").forward(request, response);

		} else {
			//注册成功，跳转到首页(使用重定向方式)
			//要保存用户信息
			//session.setAttribute("username", userName);
			//设置session的过期
			//session.setMaxInactiveInterval(5);
			//使用cookie记录用户名，实现自动填写用户名功能

			//创建cookie对象,参数为键值对
			//如果有中文，先采用utf-8编码
			//userName = URLEncoder.encode(userName, "utf-8");
			//Cookie cookie = new Cookie("username", userName);
			//不同层级，需要设置cookie路径
			//cookie.setPath("/");
			//设置cookie失效时间
			//cookie.setMaxAge(60 * 60);
			//添加cookie
			//response.addCookie(cookie);
			session.setAttribute("ousername", userName);
			response.sendRedirect(request.getContextPath() + "/index.jsp?username="+userName);
		}
	%>

	用户名：
	<br />
	<%
		if (userName != null && !userName.equals("")) {
			//JSP默认使用ISO-8859-1编码格式，因此可以先按这个格式将用户名字符串打散为字节
			//byte[] userNames = userName.getBytes("ISO-8859-1");

			//然后再将该字节数组按照utf-8编码格式重新拼接为字符串
			//userName = new String(userNames, "utf-8");

			//userName = new String(userName.getBytes("ISO-8859-1"),"utf-8");

			out.println(userName);
		} else {
			out.println("没有填写用户名");
		}
	%>
	<br /> 密码：
	<%=pwd%><br /> email:
	<%=email%><br /> 爱好：
	<%
		if (hobbys != null && hobbys.length != 0) {
			for (String hobby : hobbys) {
				out.println(hobby + "<br/>");
			}
		} else {
			out.println("没有选择爱好！");
		}
	%><br />

</body>
</html>
