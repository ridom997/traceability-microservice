package com.pragma.powerup.traceabilitmicroservice.configuration.security.jwt;


import com.pragma.powerup.traceabilitmicroservice.configuration.Constants;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    JwtProvider jwtProvider;


    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
            throws ServletException, IOException {
        RequestHolder.setHttpServletRequest(req); //we assign this variable to use it in the getToken method
        String token = getToken();
        if (token != null && jwtProvider.validateToken(token)) {
            Claims claimsFromToken = jwtProvider.getClaimsFromToken(token);
            if(claimsFromToken.get("roles") != null){

                List<String> authorities = (List<String>) claimsFromToken.get("roles");
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claimsFromToken.getSubject(), null,
                        authorities.stream().map(SimpleGrantedAuthority::new).toList());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }else{
                SecurityContextHolder.clearContext();
            }
        }
        filterChain.doFilter(req, res);
    }

    public static String getToken() {
        String header = RequestHolder.getHttpServletRequest().getHeader(Constants.AUTHORIZATION_HEADER);
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7); // return everything after "Bearer "
        }
        return null;
    }

    class RequestHolder{

        private RequestHolder(){}
        private static HttpServletRequest httpServletRequest;

        public static HttpServletRequest getHttpServletRequest() {
            return httpServletRequest;
        }

        public static void setHttpServletRequest(HttpServletRequest httpServletRequest) {
            RequestHolder.httpServletRequest = httpServletRequest;
        }
    }

}
