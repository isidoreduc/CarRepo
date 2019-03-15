package com.example.cardatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import com.example.cardatabase.service.UserDetailServiceImpl;

/**
 * This class will replace the default basic security, to be able to configure which endpoints will be secured
 * @author raspi
 *
 */
@Configuration @EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	  private UserDetailServiceImpl userDetailsService;

	
//	@Override
//	  protected void configure(HttpSecurity http) throws Exception {
//
//	  }
	
//	// in-memory security credentials, only to be used for development
//	// for production, credentials should be stored in database, encrypted
//	@Bean
//	  @Override
//	  public UserDetailsService userDetailsService() {
//	      UserDetails user =
//	           User
//	              .withUsername("user")
//	              .password("password")
//	              .roles("USER")
//	              .build();
//
//	      return new InMemoryUserDetailsManager(user);
//	  } 
	
	
	// real global security config stored in database, with encrypted password (*disable in-memory security)
	@Autowired
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService)
	    .passwordEncoder(new BCryptPasswordEncoder());
	  }

}
