package com.example.demo0812.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexContller {
    @RequestMapping({"","index"})
    public String index(Model model){

        model.addAttribute("pcode", new String());

        return "index";
    }

}
