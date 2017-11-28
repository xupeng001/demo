package com.shard.session.app;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor extends HandlerInterceptorAdapter implements
		HandlerInterceptor {

	/**
	 * 基于session
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
		//
		// String sessionId = getCookie(request, Application.SESSION_ID);
		// System.out.println("sessionId : " + sessionId);
		// if (sessionId != null) {
		// HttpSession session = Application.map.get(sessionId);
		// Object user = session.getAttribute(Application.SESSION_USER);
		// System.out.println("user : " + user);
		// if (user != null) {
		// return true;
		// }
		// } else {
		// response.sendRedirect("/login");
		// }
		return true;
	}

	// /**
	// * 基于cookie
	// */
	// @Override
	// public boolean preHandle(HttpServletRequest request,
	// HttpServletResponse response, Object obj) throws Exception {
	// String user = getCookie(request, Application.COOKIE_NAME);
	// System.out.println(user);
	// if (user != null) {
	// return true;
	// }
	// return false;
	// }

	private String getCookie(HttpServletRequest request, String key) {
		if (key == null) {
			return null;
		}

		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (key.equals(cookie.getName())) {
				return cookie.getValue();
			}
		}
		return null;

	}

}
