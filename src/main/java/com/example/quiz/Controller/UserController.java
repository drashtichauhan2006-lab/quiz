package com.example.quiz.controller;

import com.example.quiz.DTO.GetResultResponse;
import com.example.quiz.DTO.UserRegisterResponse;
import com.example.quiz.model.User;
import com.example.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("register")
    public UserRegisterResponse register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("{userName}/result")
    public GetResultResponse result(@PathVariable String userName) {
        return userService.getResult(userName);
    }
}
