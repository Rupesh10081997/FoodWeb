package com.main.Authentication.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.dto.response.ErrorResponse;
import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.main.Authentication.Service.JwtService;

import java.io.IOException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
    private JwtService jwtService;
	@Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws  ServletException, IOException {
        Optional<String> authHeader = Optional.ofNullable(request.getHeader("Authorization"));
        if (authHeader.isEmpty() || !authHeader.get().startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        try{
            final String jwt = authHeader.get().substring(7);
            final String userId = jwtService.extractUsername(jwt);
            if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                var userDetails = this.userDetailsService.loadUserByUsername(userId);

                if (jwtService.isTokenValid(jwt, userDetails)) {
                    final var authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
            filterChain.doFilter(request, response);
        }catch (ExpiredJwtException ex) {
            // Handle expired token
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setError("ExpiredJwtException");
            errorResponse.setError_desc("Token has expired.");
            response.getWriter().write(new ObjectMapper().writeValueAsString(errorResponse));
        } catch (MalformedJwtException  | UnsupportedJwtException ex) {
            // Handle invalid token
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setError("MalformedJwtException And UnsupportedJwtException");
            errorResponse.setError_desc("Invalid token.");
            response.getWriter().write(new ObjectMapper().writeValueAsString(errorResponse));
        } catch (UsernameNotFoundException ex) {
            // Handle user not found
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setError("UsernameNotFoundException");
            errorResponse.setError_desc("User not found.");
            response.getWriter().write(new ObjectMapper().writeValueAsString(errorResponse));
        } catch (Exception ex) {
            // Handle any other exceptions
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setError("INTERNAL_SERVER_ERROR");
            errorResponse.setError_desc("An unexpected error occurred.");
            response.getWriter().write(new ObjectMapper().writeValueAsString(errorResponse));
        }
    }
}