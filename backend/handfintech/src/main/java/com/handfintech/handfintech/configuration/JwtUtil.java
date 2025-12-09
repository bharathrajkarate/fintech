package com.handfintech.handfintech.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "this_is_my_secret_key_for_jwt_token_1234567890";
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String username) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(username)
                .claim("role", "admin")
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + (10 * 60 * 1000))) // 10 minutes
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    public boolean validateToken(String token) {
        String jwt = token;
        return !isTokenExpired(jwt);
    }

    public Claims getClaims(String token) {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
    }


    public boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    // Delete a jwt token in the HttpsOnly cookies
    public void deleteCurrentToken(HttpServletResponse response) {

        ResponseCookie deleteOld = ResponseCookie.from("Jkjsdfklj_lksjdf_878", "")
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(0)
                .sameSite("None")
                .build();
        response.addHeader("Set-Cookie", deleteOld.toString());
    }

    // Set a jwt token in the HttpsOnly cookies
    public void addCurrentToken(HttpServletResponse response,String token) {

        ResponseCookie cookie = ResponseCookie.from("Jkjsdfklj_lksjdf_878", token)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(600)     // 10 minutes
                .sameSite("None")
                .build();
        response.addHeader("Set-Cookie", cookie.toString());
    }

}
