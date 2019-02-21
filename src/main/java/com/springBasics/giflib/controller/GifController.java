package com.springBasics.giflib.controller;

import com.springBasics.giflib.model.Gif;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class GifController {
    @RequestMapping(value = "/")
    public String listGifs() {
        return "home";
    }

    @RequestMapping("/gif")
    public String gifDetails(ModelMap modelMap) {
        Gif gif = new Gif("android-explosion", LocalDate.of(2019, 2, 23), "Himanshu Mittal", true);
        modelMap.put("gif", gif);
        return "gif-details";
    }
}
