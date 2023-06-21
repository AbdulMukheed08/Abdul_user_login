package com.example.Abdul_user_login1.Service;

import com.example.Abdul_user_login1.Entity.User;
import com.example.Abdul_user_login1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(User user) throws Exception{
        List<User> userList = new ArrayList<>();

        userList = userRepository.findAll();

        for(User other : userList){
            if(other.equals(user)){
                throw new Exception("User already exists!");
            }
        }

        userRepository.save(user);

        return "User added successfully";
    }

    public String userLogin(String username, String password)throws Exception {

        List<User> userList = userRepository.findAll();

        for(User user : userList){

            String currUsername = user.getUsername();
            String currPassword = user.getPassword();

            if(username.equals(currUsername)){
                if(password.equals(currPassword)){
                    return "Logged in successfully";
                }
                else{
                    return "Incorrect Password!!";
                }
            }
        }

        throw new Exception("User does not exist");
    }
}
