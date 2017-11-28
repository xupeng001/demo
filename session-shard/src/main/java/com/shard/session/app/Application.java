package com.shard.session.app;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	Logger log = org.slf4j.LoggerFactory.getLogger(getClass());

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;

	public static String COOKIE_NAME = "cookie_user";
	public static String SESSION_USER = "USER";
	public static String SESSION_ID = "JSESSIONID";

	public final static ConcurrentHashMap<String, HttpSession> map = new ConcurrentHashMap<String, HttpSession>();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * 跨域共享cookie
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/session")
	public String shared() {
		String result = null;
		HttpSession session = null;
		String sessionId = "";
		Cookie cookie = getCookie(request, SESSION_ID);
		if (cookie != null) {
			sessionId = cookie.getValue();
		}
		if (sessionId == null) {
			result = "not have";
		} else {
			if ((session = map.get(sessionId)) == null) {
				result = "not have";
			} else {
				result = "having";
			}
		}

		log.info("method shared  " + sessionId + " : " + session);
		return result
				+ " hello:"
				+ (session == null ? "null" : session
						.getAttribute(SESSION_USER));
	}

	@RequestMapping(value = "/login.json", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SSOInfo login() {
		HttpSession session = null;
		String sessionId = "";
		Cookie cookie = getCookie(request, SESSION_ID);
		if (cookie != null) {
			sessionId = cookie.getValue();
		}
		if (StringUtils.isEmpty(sessionId)) {
			session = request.getSession();
			sessionId = session.getId();
			map.put(sessionId, session);
			Cookie cookie_new = new Cookie(SESSION_ID, sessionId);
			cookie_new.setPath("/");
			cookie_new.setDomain("aliyun-inc.test");
			response.addCookie(cookie_new);
		} else {
			if ((session = map.get(sessionId)) == null) {
				session = request.getSession();
				sessionId = session.getId();
				map.put(sessionId, session);
				Cookie cookie_new = new Cookie(SESSION_ID, sessionId);
				cookie_new.setPath("/");
				cookie_new.setDomain("aliyun-inc.test");
				response.addCookie(cookie_new);
			}
		}
		session.setAttribute(SESSION_USER, "xupeng");
		log.info("method login  " + sessionId + " : " + session);
		return new SSOInfo("http://sales.aliyun-inc.test/session");

	}

	@RequestMapping("/url")
	public void redirectUrl() throws IOException {
		Cookie cookie = new Cookie("url", "www.login.com");
		cookie.setPath("/");
		cookie.setDomain("app");
		response.addCookie(cookie);
		String token = UUID.randomUUID().toString();
		response.sendRedirect("https://www.baidu.com?token=" + token);
	}

	public static Cookie getCookie(HttpServletRequest request, String name) {
		Assert.notNull(request, "Request must not be null");
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (name.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}

}
