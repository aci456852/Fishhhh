package com.example.demo0812.Controller;

import com.example.demo0812.bean.Rule;
import com.example.demo0812.service.FileService;
import com.example.demo0812.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @RequestMapping("listALL")
    @ResponseBody
    public ModelAndView listALL(){
        ModelAndView mav = new ModelAndView("rule");
        List<Rule> rules=ruleService.listALL();
        mav.addObject("rules",rules);
        return mav;
    }

    @RequestMapping("ruleQuery")
    @ResponseBody
    public List<Rule> ruleQuery(String pcode){
        List<Rule> rules=ruleService.ruleQuery("GZ01010101");
        for (Rule r:rules){
            System.out.println("ruleQuery:"+r.getPname()+ " code:" +r.getPcode());
        }
        return rules;
    }

    @RequestMapping("ruleInsert")
    @ResponseBody
    public void ruleInsert(Rule rule){
        ruleService.ruleInsert(rule);
    }

    @RequestMapping("ruleUpdate")
    @ResponseBody
    public void ruleUpdate(String pname, String ppos){
        ruleService.ruleUpdate(pname,ppos);
    }

    @RequestMapping("ruleDelete")
    @ResponseBody
    public void ruleDelete(String pname){
        ruleService.ruleDelete(pname);
    }
}
