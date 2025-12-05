package com.handfintech.handfintech.controller;

import com.handfintech.handfintech.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class NavigationController {

    @Autowired
    UserLoginService userLoginService;
    @PostMapping("/login")
    public String Login(@RequestBody Map<String,Object>data){
        return userLoginService.UserLoginCheckService(data);
    }
}
