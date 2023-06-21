package com.example.Abdul_user_login1.Controller;


import com.example.Abdul_user_login1.Entity.User;
import com.example.Abdul_user_login1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public String addUser(@RequestBody User user){
        String response = "";

        try{
            response = userService.addUser(user);
        }
        catch(Exception e){
            response = e.getMessage();
        }

        return response;
    }

    @GetMapping("/login")
    public String userLogin(@RequestParam String username, @RequestParam String password){

        String response = "";

        try{
            response = userService.userLogin(username,password);
        }
        catch(Exception e){
            response = e.getMessage();
        }

        return response;
    }
}
