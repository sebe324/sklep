package com.sklep.sklepapi.controllers;

import com.sklep.sklepapi.repositories.UserRepository;
import com.sklep.sklepapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/")
    public String main(){
        return "Strona Glowna";
    }
    @GetMapping("/api/liczba")
    public int num(){
        return 420;
    }
    @GetMapping("/api/users")
    public List<User> showUsers(){
        return userRepository.getUsers();
    }
}
