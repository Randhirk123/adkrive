

package com.adkrive.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.adkrive.main.adminservice.CustomAdminDetailsService;
import com.adkrive.main.auth.CustomLoginFailureHandler;
import com.adkrive.main.auth.CustomLoginSuccessHandler;

@Order(1)
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean(autowireCandidate = true)
	public UserDetailsService userDetailsService() {
		return new CustomAdminDetailsService();
	}


	@Bean(autowireCandidate = true)
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(resources).permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/admin").usernameParameter("userName").passwordParameter("password")
				.failureHandler(loginFailureHandler).successHandler(loginSuccessHandler).permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll().logoutSuccessUrl("/admin").and()
				.exceptionHandling().accessDeniedPage("/access-denied");

	}

	String[] resources = new String[] { "/admin", "/dashboard", "/profile", "/css/**", "/fonts/**", "/images/**",
			"/js/**", "/build/**", "/assets/**", "/webfonts/**", "/extensions/**", "/logoIcon/**" };

	@Autowired
	private CustomLoginFailureHandler loginFailureHandler;

	@Autowired
	private CustomLoginSuccessHandler loginSuccessHandler;
}


