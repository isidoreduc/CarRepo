package com.example.cardatabase;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.cardatabase.service.UserDetailServiceImpl;

/**
 * This class will replace the default basic security, to be able to configure
 * which endpoints will be secured Call /login endpoint with POST method (in
 * Postman fx.) and provide user and pass to get token Then use token to access
 * API
 * 
 * @author raspi
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests().antMatchers(HttpMethod.POST, "/login").permitAll().anyRequest()
				.authenticated().and()
				// Filter for the api/login requests
				.addFilterBefore(new LoginFilter("/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)
				// Filter for other requests to check JWT in header
				.addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("*"));
		config.setAllowedMethods(Arrays.asList("*"));
		config.setAllowedHeaders(Arrays.asList("*"));
		config.setAllowCredentials(true);
		config.applyPermitDefaultValues();

		source.registerCorsConfiguration("/**", config);
		return source;
	}

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

	// real global security config stored in database, with encrypted password
	// (*disable in-memory security)
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//	}

}
