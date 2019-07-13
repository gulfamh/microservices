package com.in28minutes.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// to execute filter or not 
	@Override
	public boolean shouldFilter() {
		return true;
	}

	

	// when shouild filtyer happen b4 the req is exe or after req exe or when error on req
	@Override
	public String filterType() {
		return "pre";
	}

	//to set priorty order for multiple filter
	@Override
	public int filterOrder() {
		return 1;
	}


// real logic 
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = 
				RequestContext.getCurrentContext().getRequest();
	
		logger.info("request -> {} request uri -> {}", 
				request, request.getRequestURI());
		
		return null;
	}
}