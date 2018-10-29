package cn.kgc.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.pojo.News_user;

public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 判断用户是否登陆（检查session中的user是否存在）

		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rp = (HttpServletResponse) response;

		News_user user = (News_user) rq.getSession().getAttribute("user");
		if (user == null) {
			rp.sendRedirect(rq.getContextPath() + "/jsp/error.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
