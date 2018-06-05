package com.ncs.zhilongcloud;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PreZuulFilter extends ZuulFilter {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PreZuulFilter.class);

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public Object run() {
		HttpServletRequest request = RequestContext.getCurrentContext()
				.getRequest();
		String remoteHost = request.getRemoteHost();
		LOGGER.info("The Host request:", remoteHost);
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

}
