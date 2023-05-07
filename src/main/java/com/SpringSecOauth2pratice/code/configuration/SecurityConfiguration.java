package com.SpringSecOauth2pratice.code.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.oauth2.provider.filter;





@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	@Bean
	public UserDetailsService userdetailservice()
	{
		InMemoryUserDetailsManager user=new InMemoryUserDetailsManager();
		user.createUser(User.withUsername("ram").password("password").authorities("read").roles("admin").build());
		
		return user;
	}
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http.formLogin();
		http.authorizeHttpRequests().anyRequest().authenticated();
	}
	

	
	
	


	
	

}
