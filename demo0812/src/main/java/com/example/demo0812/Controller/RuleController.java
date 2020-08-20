package com.example.demo0812.Controller;

import com.example.demo0812.bean.Rule;
import com.example.demo0812.service.RuleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Rule")
public class RuleController{
    @Autowired
    private RuleService ruleService;


    @GetMapping("/queryRule/")
    public ModelAndView ruleQuery(Rule rule,Model model) {
        List<Rule> rules = ruleService.ruleQuery(rule.getPcode());
        model.addAttribute("ruleList",rules);
        model.addAttribute("title", "查询规则");
        return new ModelAndView("rules/queryRule","ruleModel",model);
    }

    @GetMapping("/addRule")
    public ModelAndView createRule(@Param("pname") String pname,
                             @Param("pcode") String pcode,
                             @Param("ppos") String ppos,
                             @Param("ptype") String ptype,
                             Model model) {
        Rule rule = new Rule();
        rule.setPname(pname);
        rule.setPcode(pcode);
        rule.setPpos(ppos);
        rule.setPtype(ptype);
        //ruleService.ruleInsert(rule);
        Rule r = new Rule();
        Rule r2 = new Rule();
        Rule r3 = new Rule();
        r.setPcode("Pcode");
        r.setPname("Pname");
        r.setPpos("PPos");
        r.setPtype("ptype");

        r2.setPcode("Pcode2");
        r2.setPname("Pname2");
        r2.setPpos("PPos2");
        r2.setPtype("ptype2");

        r3.setPpos(ppos);
        r3.setPcode(pcode);
        r3.setPname(pname);
        r3.setPtype(ptype);
        List<Rule> rules = new ArrayList<Rule>();;
        rules.add(r);
        rules.add(r2);
        rules.add(r3);
        model.addAttribute("rules",rules);
        return new ModelAndView("Rule/tables","rulemodel",model);
    }

    @PostMapping("insert")
    public ModelAndView insert(Rule rule){
        System.out.println(rule);
        ruleService.ruleInsert(rule);
        return new ModelAndView("redirect:/index");
    }


    @GetMapping("/ruleUpdate/{pcode}")
    public ModelAndView UpdateRule(@PathVariable("pname") String pcode, Model model) {
        model.addAttribute("rule", ruleService.ruleQuery(pcode));
        model.addAttribute("title","修改规则");
        //ruleService.ruleUpdate(pname,ppos);
        return new ModelAndView("rules/ruleUpdate","ruleModel",model);//重定向到list页面
    }

    @PostMapping("modify")
    public ModelAndView modify(Rule rule){
        String pname = rule.getPname();
        String pcode = rule.getPcode();
        ruleService.ruleUpdate(pname, pcode);
        return new ModelAndView("redirect:/index");
    }

    @GetMapping("/ruleDelete/{pname}")
    public void ruleDelete(@PathVariable("pname") String pname) {
        System.out.println("进入文件删除模块："+pname);
        ruleService.ruleDelete(pname);
    }

}