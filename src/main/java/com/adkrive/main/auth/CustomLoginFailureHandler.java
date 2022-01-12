package com.adkrive.main.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.adkrive.main.adminservice.AdminService;
import com.adkrive.main.model.Admin;
import com.adkrive.main.utility.UtilityConstant;




@Component
public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
     
    @Autowired
    private AdminService adminService;
     
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("userName");
        Admin admin = adminService.getAdminByUserName(username);
         
        if (admin != null) {
            if (admin.isAccountNonLocked()) {
                if (admin.getFailedAttempt() < UtilityConstant.MAX_FAILED_ATTEMPTS - 1) {
                	adminService.increaseFailedAttempts(admin);
                } else {
                	adminService.lock(admin);
                    exception = new LockedException("Your account has been locked due to 3 failed attempts."
                            + " It will be unlocked after 24 hours.");
                }
            } else if (!admin.isAccountNonLocked()) {
                if (adminService.unlockWhenTimeExpired(admin)) {
                    exception = new LockedException("Your account has been unlocked. Please try to login again.");
                }
            }
             
        }
        String redirectURL="/admin?error";
        String error = exception.getMessage();
        System.out.println("A failed login attempt with email: "
                            + username + ". Reason: " + error);
        super.setDefaultFailureUrl(redirectURL);
        super.onAuthenticationFailure(request, response, exception);
        
    }
 
}
