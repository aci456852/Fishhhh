package com.example.demo0812.Controller;


import com.example.demo0812.bean.Rule;
import com.example.demo0812.service.FileService;
import com.example.demo0812.service.RuleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class loginController {

    private RuleService ruleService;

    @RequestMapping("/login")
    public String index(
            @Param("email") String email,
            @Param("password") String password,
            Model model){
        System.out.println(email+"  "+password);
        //List<Rule> rules = ruleService.listALL();
        Rule r = new Rule();
        r.setPcode("Pcode");
        r.setPname("Pname");
        r.setPpos("PPos");
        r.setPtype("ptype");
        Rule r2 = new Rule();
        r2.setPcode("Pcode2");
        r2.setPname("Pname2");
        r2.setPpos("PPos2");
        r2.setPtype("ptype2");
        List<Rule> rules = new ArrayList<Rule>();;
        rules.add(r);
        rules.add(r2);
        System.out.println(rules.get(0).toString());
        model.addAttribute("rules",rules);

        return "redirect:/main.html";
    }
}
