package com.QuizeAppBackend.Security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private CustomUserDetailsService userDetailsService; 
	@Autowired
	private JWTTokenHelper jwttokenhelper; 
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		System.out.println("request: "+request);
//		System.out.println("responce: "+response);
//		System.out.println("filterChain: "+filterChain);

		String requestToken = request.getHeader("Authorization");
		System.out.println(requestToken);
		String username =null;
		String token =null;
		if(requestToken!=null && requestToken.startsWith("Bearer"))
		{
			token = requestToken.substring(7); 
			try {
	            username = jwttokenhelper.extractUsername(token); 

			}
			catch(IllegalArgumentException e )
			{
//				throw an error here 
				System.out.println("Unable to get token here");
			}
			catch(ExpiredJwtException e)
			{
//				throw an error here
				System.out.println("token is expired");
			}
			catch(MalformedJwtException e)
			{
//				throw an exception here 
				System.out.println("token malformed");
			}
			catch(Exception e)
			{
//				throw error here 
				System.out.println("you are not authenticated");
			}
            
            
		}
		else {
//			throw an error here 
			System.out.println("Token is not found");
		}
		
		
		if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails = userDetailsService.loadUserByUsername(username); 
			if(jwttokenhelper.validateToken(token, userDetails))
			{
			      RequestAttributeSecurityContextRepository repository = new RequestAttributeSecurityContextRepository();
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		        SecurityContext context = SecurityContextHolder.createEmptyContext();
		        context.setAuthentication(usernamePasswordAuthenticationToken);
//		        context.authentication = JwtUser(usernamePasswordAuthenticationToken)
		        SecurityContextHolder.setContext(context);

//				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		         repository.saveContext(context, request, response);


			}
			else {
//				throw error here 
				System.out.println("Token is not valid");
			}
		}
		else {
//			throw error here 
			
			System.out.println("You are not an authenticated user");
		}
		
 		filterChain.doFilter(request, response);
 		
 		System.out.println("After filter chain");

		
	}
}
