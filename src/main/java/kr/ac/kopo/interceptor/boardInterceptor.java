package kr.ac.kopo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.model.Users;

public class boardInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();

		Users item = (Users) session.getAttribute("users");
		Users users = (Users) session.getAttribute("item"); // 

		if (item.getId() == users.getId())
			return true;
		
		else
			response.sendRedirect("/");

		return false;
	}
}
