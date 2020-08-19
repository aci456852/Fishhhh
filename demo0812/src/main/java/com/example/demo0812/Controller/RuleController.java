package com.example.demo0812.Controller;


//package com.example.demo0812.Controller;
//
//import com.example.demo0812.bean.Rule;
//import com.example.demo0812.service.RuleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//public class RuleController {
//
//    @Autowired
//    private RuleService ruleService;
//
//    @RequestMapping("rule")
//    @ResponseBody
//    public ModelAndView listALL(Model model){
//
//        ModelAndView mav = new ModelAndView("rule");
//        List<Rule> rules=ruleService.listALL();
//        mav.addObject("rules",rules);
//        return mav;
//    }
//
//    @GetMapping("{id}")
//    public List<Rule> ruleQuery(String pcode){
//        List<Rule> rules=ruleService.ruleQuery("GZ01010101");
//        for (Rule r:rules){
//            System.out.println("ruleQuery:"+r.getPname()+ " code:" +r.getPcode());
//        }
//        return rules;
//    }
//
//    @RequestMapping(value = "/ruleInsert", method = RequestMethod.POST)
//    public void ruleInsert(@ModelAttribute(value="rule") Rule rule){
//        ruleService.ruleInsert(rule);
//    }
//
//    @GetMapping("/ruleUpdate/{pname}+{ppos}")
//    public void ruleUpdate(@PathVariable("pname") String pname, String ppos){
//        ruleService.ruleUpdate(pname,ppos);
//    }
//
//    @GetMapping("/ruleDelete/{pname}")
//    public void ruleDelete(@PathVariable("pname") String pname){
//        System.out.println(pname);
//        ruleService.ruleDelete(pname);
//    }
//}
import com.example.demo0812.bean.Rule;
import com.example.demo0812.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class RuleController{
    @Autowired
    private RuleService ruleService;

    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("ruleList", ruleService.listALL());
        model.addAttribute("title", "规则管理");
        return new ModelAndView("rules/rule","ruleModel",model);
    }

    @GetMapping("/queryRule/{pcode}")
    public ModelAndView ruleQuery(@PathVariable("pcode") String pcode,Model model) {
        List<Rule> rules = ruleService.ruleQuery(pcode);
        model.addAttribute("ruleList",rules);
        model.addAttribute("title", "查询规则");
        return new ModelAndView("rules/queryRule","ruleModel",model);
    }

    @GetMapping("/addRule")
    public ModelAndView createRule(Model model) {
        model.addAttribute("rule",new Rule());
        model.addAttribute("title", "创建规则");
        return new ModelAndView("rules/addRule","ruleModel",model);
    }

    @PostMapping
    public ModelAndView UpdateRule(String pname, String ppos) {
        ruleService.ruleUpdate(pname,ppos);
        return new ModelAndView("redirect:/rules");//重定向到list页面
    }

    @GetMapping("/ruleDelete/{pname}")
    public ModelAndView ruleDelete(@PathVariable("pname") String pname) {
        ruleService.ruleDelete(pname);
        return new ModelAndView("redirect:/rules");//重定向到list页面
    }

}