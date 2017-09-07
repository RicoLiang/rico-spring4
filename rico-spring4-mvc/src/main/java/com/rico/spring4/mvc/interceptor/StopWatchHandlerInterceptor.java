package com.rico.spring4.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rico.spring4.mvc.util.JodaTimeUtil;

public class StopWatchHandlerInterceptor extends HandlerInterceptorAdapter {

	private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");
	private Logger logger = LoggerFactory.getLogger(StopWatchHandlerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long start = JodaTimeUtil.getNow().getMillis();
		startTimeThreadLocal.set(start);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long end = JodaTimeUtil.getNow().getMillis();
		Long start = startTimeThreadLocal.get();
		long consumeTime = end - start;
		logger.info("{} consume {} millis", request.getRequestURI(), consumeTime);
	}
}
