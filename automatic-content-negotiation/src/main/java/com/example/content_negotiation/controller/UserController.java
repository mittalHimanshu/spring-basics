package com.example.content_negotiation.controller;

import com.example.content_negotiation.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

/**
 * Server can decide what response to return
 * jackson-dataformat-xml library is used for automatic content negotiation
 * */

public class UserController {

    @GetMapping(produces = {"application/xml"}) // <---- Deciding factor to return only xml not json or other type
    public @ResponseBody
    User returnJSONOrXml(){
        return new User(1610991368, "Himanshu Mittal");
    }

}
