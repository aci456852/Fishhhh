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

    @RequestMapping("/listAll")
    public ModelAndView listAll(){
        ModelAndView model=new ModelAndView("/rule/tables");
        List<Rule> rules = ruleService.listALL();
        model.addObject("rules",rules);
        return model;
    }

    @RequestMapping("/Query")
    public ModelAndView ruleQuery(@Param("ppos") String ppos) {
        List<Rule> rules = ruleService.ruleQuery(ppos);
        //更新表格
        ModelAndView model=new ModelAndView("/rule/tables");
        model.addObject("rules",rules);
        return model;
    }

    @RequestMapping("/Insert")
    public ModelAndView ruleInsert(@Param("pname") String pname,
                                   @Param("pcode") String pcode,
                                   @Param("ppos") String ppos,
                                   @Param("ptype") String ptype) {
        Rule rule = new Rule(pname,pcode,ppos,ptype);
        ruleService.ruleInsert(rule);
        //更新表格
        ModelAndView model=new ModelAndView("/rule/tables");
        List<Rule> rules = ruleService.listALL();
        model.addObject("rules",rules);
        return model;
    }

 // 修改没成功 等前端给个框~
    @RequestMapping("/Update/{pid}")
    public ModelAndView UpdateRule(@PathVariable("pid") int pid,@Param("ppos") String ppos) {
        ruleService.ruleUpdate(pid, ppos);//更新表格
        ModelAndView model=new ModelAndView("/rule/tables");
        List<Rule> rules = ruleService.listALL();
        model.addObject("rules",rules);
        return model;
    }

    @RequestMapping("/Delete/{pid}")
    public ModelAndView ruleDelete(@PathVariable("pid") int pid) {
        ruleService.ruleDelete(pid);
        //更新表格
        ModelAndView model=new ModelAndView("/rule/tables");
        List<Rule> rules = ruleService.listALL();
        model.addObject("rules",rules);
        return model;
    }

}