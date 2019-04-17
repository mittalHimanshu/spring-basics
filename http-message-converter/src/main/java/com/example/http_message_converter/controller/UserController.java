package com.example.http_message_converter.controller;

import com.example.http_message_converter.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping
    public @ResponseBody User returnJSONOrXml(){
        return new User(1, "Himanshu Mittal");
    }

}
