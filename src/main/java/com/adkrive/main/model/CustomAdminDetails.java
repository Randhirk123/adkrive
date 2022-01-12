package com.adkrive.main.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomAdminDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5361131497064169634L;
	
	private Admin admin;
	public CustomAdminDetails(Admin admin)
	{
		this.admin=admin;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		return admin.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return admin.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getFullName()
	{
		return admin.getName();
	}

}
