package com.SpringSecOauth2pratice.code.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerSecurityConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;


@Configuration
@EnableAuthorizationServer
public class CustomAuthorizationServer extends AuthorizationServerConfigurerAdapter{

	@Autowired 
	AuthenticationManager authenticationManager;
	
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clientDetails) throws Exception {
		
		clientDetails.inMemory().withClient("falam").secret("123456").
		scopes("read").authorizedGrantTypes("password").and().
		withClient("bipu").secret("123456").
		scopes("read").authorizedGrantTypes("authorization_code").redirectUris("http://localhost:8080")
		.and()
		.withClient("krishna").secret("123456789").scopes("READ_WRITE_TRUST").authorizedGrantTypes("client_credentials");
		
		
		
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoint) {
		endpoint.authenticationManager(authenticationManager);
	}
	
	

}
