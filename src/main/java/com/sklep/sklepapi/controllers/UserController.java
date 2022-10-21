package com.sklep.sklepapi.controllers;

import com.sklep.sklepapi.repositories.UserRepository;
import com.sklep.sklepapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/hello")
    public String main(){
        return "/WEB-INF/views/demo.jsp";
    }
    @GetMapping("/api/users")
    public List<User> showUsers(){
        return userRepository.getUsers();
    }
    @GetMapping("/api/users/{id}")
    public User showUserById(@PathVariable("id") int id){
        return userRepository.getUserById(id);
    }
    @PostMapping("/api/users/add")
    public int addUsers(@RequestBody List<User> users){
        return userRepository.addUsers(users);
    }
    @GetMapping("/api/users/update")
    public String putUser(){
        return "TODO update-PUT";
    }
    @GetMapping("/api/users/patch")
    public String patchUser(){
        return "TODO update-patch";
    }
    @DeleteMapping("/api/users/delete/{id}")
    public void deleteUserById(@PathVariable("id") int id){
        userRepository.deleteUser(id);
    }
}
