package com.adkrive.main.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomRestDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private RestClientRegistration clientRegistration;
	public CustomRestDetails(RestClientRegistration clientRegistration)
	{
		this.clientRegistration=clientRegistration;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		
		return clientRegistration.getPassword();
	}

	@Override
	public String getUsername() {
		
		return clientRegistration.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
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
		return clientRegistration.getName();
	}

}
