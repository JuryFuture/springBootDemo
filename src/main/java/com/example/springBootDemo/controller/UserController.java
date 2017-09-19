package com.example.springBootDemo.controller;

import com.example.springBootDemo.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserHandler userHandler;
}
