package com.example.unittesting.controller;

import com.example.unittesting.model.DemoJSON;
import com.example.unittesting.service.HelloService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private HelloService helloService;

    public DemoController(HelloService helloService){
        this.helloService = helloService;
    }

    @GetMapping
    public String returnHello(){
        return helloService.returnHello();
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public DemoJSON returnJson(){
        return new DemoJSON("Himanshu", "1610991368");
    }

    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DemoJSON testPost(@RequestBody DemoJSON demoJSON){
        return demoJSON;
    }

}
