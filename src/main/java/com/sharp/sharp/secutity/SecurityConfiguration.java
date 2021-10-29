/**
 * Created By Elavarasan Ramasamy
 * Created 19-December-2016
 * This file Security Configuration is used to configure the basic Authentication of Spring
 */
package com.sharp.sharp.secutity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static String REALM = "MY_TEST_REALM";

	/**
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("sharp").password("sharp@123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("sharp").password("sharp@123").roles("USER");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/user/**").hasRole("ADMIN").and().formLogin()
				.loginPage("/login.jsp").failureUrl("/login.jsp?error=1").loginProcessingUrl("/login").permitAll().and()
				.logout().logoutSuccessUrl("/listEmployees.html");

	}

	/**
	 * @param <HttpSecurity>
	 * @return None
	 */
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/user/**").hasRole("ADMIN").and().httpBasic()
				.realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint());
	}*/

	/**
	 * @param None
	 * @return <CustomBasicAuthenticationEntryPoint> Object
	 */
/*	@Bean
	public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
		return new CustomBasicAuthenticationEntryPoint();
	}*/

	/**
	 * @param <WebSecurity>
	 * @return None
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}
}
