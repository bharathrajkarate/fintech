package com.handfintech.handfintech.configuration;

import com.handfintech.handfintech.configuration.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class JwtFilter implements Filter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURI();

        // Skip JWT validation for login/logout
        if (path.startsWith("/login") ||
                path.startsWith("/logout") ||
                path.startsWith("/api/login") ||
                path.startsWith("/api/logout")) {

            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        String token = null;

        if (request.getCookies() != null) {
            for (Cookie c : request.getCookies()) {
                if (c.getName().equals("Jkjsdfklj_lksjdf_878") && c.getValue() != null && !c.getValue().trim().isEmpty()) {
                    token = c.getValue();
                }
            }
        }

        if (token == null) {

            HttpServletResponse res = (HttpServletResponse) servletResponse;
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.setContentType("application/json");
            res.setCharacterEncoding("UTF-8");

            String json = "{\"message\":\"Token Missing\"}";

            res.getWriter().write(json);
            res.getWriter().flush();
            res.getWriter().close();

            return;
        }

        try {
            Claims claims = jwtUtil.getClaims(token);
            request.setAttribute("username", claims.getSubject());
        }
        catch (ExpiredJwtException ex) {

            HttpServletResponse res = (HttpServletResponse) servletResponse;
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.setContentType("application/json");
            res.setCharacterEncoding("UTF-8");

            String json = "{\"message\":\"Token Expired\"}";

            res.getWriter().write(json);
            res.getWriter().flush();
            res.getWriter().close();

            return;
        }
        catch (Exception e) {

            HttpServletResponse res = (HttpServletResponse) servletResponse;
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.setContentType("application/json");
            res.setCharacterEncoding("UTF-8");

            String json = "{\"message\":\"Invalid Token\"}";

            res.getWriter().write(json);
            res.getWriter().flush();
            res.getWriter().close();

            return;
        }
        chain.doFilter(servletRequest, servletResponse);
    }

}
