package kr.ac.kopo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.model.Users;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		Users users = (Users) session.getAttribute("users");
		
		if(users != null && users.getRole() == 99)
			return true;
		
		if(users == null)
			response.sendRedirect("/login");
		else
			response.sendRedirect("/");
		
		return false;
	}

}
