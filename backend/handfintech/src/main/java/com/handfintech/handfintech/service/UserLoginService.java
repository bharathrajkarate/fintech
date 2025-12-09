package com.handfintech.handfintech.service;

import com.handfintech.handfintech.Repo.UserLoginRepo;
import com.handfintech.handfintech.configuration.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserLoginService {

    @Autowired
    UserLoginRepo userLoginRepo;

    @Autowired
    private JwtUtil jwtUtil;

    public ResponseEntity<?> UserLoginCheckService(Map<String,Object> data, HttpServletResponse response) {

        String username = (String) data.get("username");
        String password = (String) data.get("password");

        int return_count = userLoginRepo.userLogin(username, password);

        if(return_count == 0) {
            // Delete cookie
            jwtUtil.deleteCurrentToken(response);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid user");
        }

        // If user found, Generate the token and set token in cookies
        String token = jwtUtil.generateToken(username);
        jwtUtil.addCurrentToken(response, token);

        return ResponseEntity.ok("Login success");
    }

    public ResponseEntity<?> UserLoginOutService(HttpServletResponse response){
        jwtUtil.deleteCurrentToken(response);
        return ResponseEntity.ok("Logged out successfully");
    }
}
