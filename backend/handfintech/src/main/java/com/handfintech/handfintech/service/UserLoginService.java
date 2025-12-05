package com.handfintech.handfintech.service;

import com.handfintech.handfintech.Repo.UserLoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserLoginService {

    @Autowired
    UserLoginRepo userLoginRepo;

    public String UserLoginCheckService(Map<String,Object> data) {

        System.out.println(data);
        System.out.println((String)data.get("username"));
        System.out.println((String)data.get("password"));
        String username=(String)data.get("username");
        String password=(String)data.get("password");

        int return_count = userLoginRepo.userLogin(username,password);

        System.out.println(return_count);
        if(return_count == 0 ){
            return "Invalid username or password";
        }else {
            return "User Login Success";
        }
    }

}
