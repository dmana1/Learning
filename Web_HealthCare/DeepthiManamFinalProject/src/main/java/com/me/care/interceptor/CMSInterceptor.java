package com.me.care.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.me.care.model.User;

public class CMSInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler)

	throws Exception {
			
		HttpSession session1 = request.getSession();
		User user = (User) session1.getAttribute("user");
		if (user != null)
		return true;
		else {
		request.setAttribute("errorFlag", "Session timed out...");
		RequestDispatcher rd = request.getRequestDispatcher("logout.htm");
		rd.forward(request, response);
		return false;
		}
	

	}
	
		

}
