package com.example.demo0812.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexContller {
    @RequestMapping("")
    public String index(){
        return "index";
    }

}
