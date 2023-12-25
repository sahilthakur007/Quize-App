package com.QuizeAppBackend.Security;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	JWTAuthenticationEntryPoint jwtauthenticationentrypoint; 
	@Autowired
	JWTAuthenticationFilter jwtauthenticationfilter; 
	@Autowired 
	CustomUserDetailsService customUserDetailService; 
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	@Primary
//	UserDetailsService userDeatilsService()
//	{
//		return new CustomUserDetailsService(); 
//	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationprovider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(this.customUserDetailService);
		return provider ; 
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests()
		.requestMatchers("/auth/login")
		.permitAll()
		.requestMatchers("/user/create").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.exceptionHandling().authenticationEntryPoint(jwtauthenticationentrypoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtauthenticationfilter, UsernamePasswordAuthenticationFilter.class);
		
		httpSecurity.authenticationProvider(daoAuthenticationprovider());
		return httpSecurity.build(); 
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean (AuthenticationConfiguration configuration) throws Exception
	{
		return configuration.getAuthenticationManager();
	}
	
//	@Bean
//	public FilterRegistrationBean<CorsFilter> corsFilter()
//	{
//		
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.setAllowCredentials(true);
//		corsConfiguration.addAllowedOriginPattern("*");
//		corsConfiguration.addAllowedHeader("Authorization");
//		corsConfiguration.addAllowedHeader("Content-Type");
//		corsConfiguration.addAllowedHeader("Accept");
//		corsConfiguration.addAllowedMethod("POST");
//		corsConfiguration.addAllowedMethod("GET");
//		corsConfiguration.addAllowedMethod("DELETE");
//		corsConfiguration.addAllowedMethod("PUT");
//		corsConfiguration.addAllowedMethod("OPTIONS");
//		corsConfiguration.setMaxAge(3600L);
//		source.registerCorsConfiguration("/**", corsConfiguration);
//	    CorsFilter corsFilter = new CorsFilter(corsConfiguration);
//		corsFilter.
//		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>();
//		bean.setFilter(corsFilter); 
//		return bean ; 
//	}
//	
}
