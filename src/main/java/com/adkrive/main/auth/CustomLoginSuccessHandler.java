package com.adkrive.main.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.adkrive.main.adminservice.AdminService;
import com.adkrive.main.model.Admin;
import com.adkrive.main.model.CustomAdminDetails;

@Component
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
 
 
	
	 @Autowired
	    private AdminService adminService;
	
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
    	CustomAdminDetails userDetails =  (CustomAdminDetails) authentication.getPrincipal();
        Admin admin=adminService.getAdminByUserName(userDetails.getUsername());
        if (admin.getFailedAttempt()>0) {
        	adminService.resetFailedAttempts(admin.getUserName());
        }
        response.sendRedirect("/dashboard");
        super.onAuthenticationSuccess(request, response, authentication);
    }
    
}
