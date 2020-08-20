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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class RuleController{
    @Autowired
    private RuleService ruleService;

    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("rule",new Rule());
        model.addAttribute("ruleList", ruleService.listALL());
        model.addAttribute("title", "规则管理");
        model.addAttribute("flag1", "flag1");
        System.out.println(model.getAttribute("flag1"));
        return new ModelAndView("rules/rule","ruleModel",model);
    }

    @GetMapping("/queryRule/")
    public ModelAndView ruleQuery(Rule rule,Model model) {
        List<Rule> rules = ruleService.ruleQuery(rule.getPcode());
        model.addAttribute("ruleList",rules);
        model.addAttribute("title", "查询规则");
        return new ModelAndView("rules/queryRule","ruleModel",model);
    }

    @GetMapping("/addRule")
    public ModelAndView createRule(@ModelAttribute(value = "rule") Rule rule,Model model) {
        System.out.println(rule);
        model.addAttribute("rule",rule);
        model.addAttribute("title", "创建规则");
        ModelAndView mav = new ModelAndView("rules/insert","ruleModel",model);
        ruleService.ruleInsert(rule);
        System.out.println(rule);
        return mav;
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
    public ModelAndView ruleDelete(@PathVariable("pname") String pname) {
        ruleService.ruleDelete(pname);
        return new ModelAndView("redirect:/rules");
    }

}