package com.handfintech.handfintech.controller;

import com.handfintech.handfintech.service.UserLoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NavigationControllerNotValidateByToken {

    @Autowired
    UserLoginService userLoginService;

    @PostMapping("login")
    public ResponseEntity<?> Login(@RequestBody Map<String,Object> data, HttpServletResponse response, HttpServletRequest request){
        System.out.println("Called the login");
        return userLoginService.UserLoginCheckService(data,response);
    }

    @GetMapping("logout_page")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        return userLoginService.UserLoginOutService(response);
    }

    // Delete the token
    @GetMapping("BBBkjdsfkjijijoieur_eriisdjf88_i8eewr898")
    public ResponseEntity<?> deleteCurentToken(HttpServletResponse response) {
        return userLoginService.UserLoginOutService(response);
    }

}
