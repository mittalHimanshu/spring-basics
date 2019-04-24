package com.example.actuator.controller;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Component
@RestControllerEndpoint(id = "custom-rest-endpoint")
public class ActuatorController {

    /**
     * custom actuator endpoint ---> http://localhost:8080/actuator/custom-rest-endpoint
     * it returns server date and time
     * */
    @GetMapping
    public Map<String, String> get() {
        Map<String, String> map = new HashMap<>();
        map.put("server.date", LocalDate.now().toString());
        map.put("server.time", LocalTime.now().toString());
        return map;
    }

}
