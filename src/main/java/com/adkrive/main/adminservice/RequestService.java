package com.adkrive.main.adminservice;

import javax.servlet.http.HttpServletRequest;

public interface RequestService {
	
	String getClientIp(HttpServletRequest request);
	
}
