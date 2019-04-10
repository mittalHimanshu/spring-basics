package com.example.unittesting.service;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

    public String returnHello(){
        return "Hello World";
    }

}
