package com.main.Authentication.filter;

import com.main.dto.exception.CustomExpiredJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.DefaultHeader;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.main.Authentication.Service.JwtService;

import java.io.IOException;
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
        }catch(Exception ex){
            //ex.printStackTrace();
            System.out.println("Throwing CustomExpiredJwtException");
            Header<?> header = new DefaultHeader<>();
            Claims claims = new DefaultClaims();
            throw new CustomExpiredJwtException(header, claims, "Token has expired !");
        }

    }
}