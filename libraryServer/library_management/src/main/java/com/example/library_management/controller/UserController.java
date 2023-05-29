package com.example.library_management.controller;

import com.example.library_management.models.User;
import com.example.library_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User createUser (@RequestBody User user) {
        return this.userService.createUser(user);
    }


}
