package com.handfintech.handfintech.controller;

import com.handfintech.handfintech.configuration.JwtUtil;
import com.handfintech.handfintech.service.UserLoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api")
public class NavigationControllerValidateByToken {

    @Autowired
    UserLoginService userLoginService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("dashboard")
    public ResponseEntity<?> dashboard(HttpServletResponse response, HttpServletRequest request) {
        System.out.println("enter into dashboard");
        return ResponseEntity.ok("You are Authorized Not Autorized User");
    }

    // To Know Which Conditioning in Token
    @GetMapping("Lkj_dkjfi_6767_67TUsf_sfjskfLKG")
    public ResponseEntity<?> requestValidation(HttpServletResponse response, HttpServletRequest request) {
        return ResponseEntity.ok("You are Authorized user");
    }
}
