package com.adkrive.main.adminservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adkrive.main.model.Admin;
import com.adkrive.main.model.CustomAdminDetails;


public class CustomAdminDetailsService implements UserDetailsService{
@Autowired
private AdminService adminService;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Admin admin=adminService.getAdminByUserName(userName);
		if(admin==null) {
			throw new UsernameNotFoundException("Admin not found");
		
		}
		
		return new CustomAdminDetails(admin);
	}

}
