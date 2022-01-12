package com.adkrive.main.feedservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adkrive.main.model.CustomRestDetails;
import com.adkrive.main.model.RestClientRegistration;


@Service
public class CustomRestClientDetailsService implements UserDetailsService {

	@Autowired
    private FeedService feedService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		RestClientRegistration clientRegistration=feedService.getClientByUsername(username);
		if(clientRegistration==null) {
			throw new UsernameNotFoundException("User not found");
		
		}
		
		return new CustomRestDetails(clientRegistration);
	}

}
