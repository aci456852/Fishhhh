package com.example.demo0812.Controller;

import com.example.demo0812.bean.Rule;
import com.example.demo0812.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @RequestMapping("rule")
    @ResponseBody
    public ModelAndView listALL(Model model){

        ModelAndView mav = new ModelAndView("rule");
        List<Rule> rules=ruleService.listALL();
        mav.addObject("rules",rules);
        return mav;
    }

    @GetMapping("{id}")
    public List<Rule> ruleQuery(String pcode){
        List<Rule> rules=ruleService.ruleQuery("GZ01010101");
        for (Rule r:rules){
            System.out.println("ruleQuery:"+r.getPname()+ " code:" +r.getPcode());
        }
        return rules;
    }

    @RequestMapping(value = "/ruleInsert", method = RequestMethod.POST)
    public void ruleInsert(@ModelAttribute(value="rule") Rule rule){
        ruleService.ruleInsert(rule);
    }

    @GetMapping("/ruleUpdate/{pname}+{ppos}")
    public void ruleUpdate(@PathVariable("pname") String pname, String ppos){
        ruleService.ruleUpdate(pname,ppos);
    }

    @GetMapping("/ruleDelete/{pname}")
    public void ruleDelete(@PathVariable("pname") String pname){
        System.out.println(pname);
        ruleService.ruleDelete(pname);
    }
}
