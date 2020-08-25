package com.example.demo0812.Controller;

import com.example.demo0812.bean.ResponseBean;
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
@RequestMapping("/Rule")
public class RuleController {
    @Autowired
    private RuleService ruleService;

    @GetMapping()
    public ResponseBean listAll() {
        List<Rule> rules = ruleService.listALL();
        return new ResponseBean(200, "succ", rules);
    }

    @GetMapping("/{ppos}")
    public ResponseBean ruleQuery(@PathVariable("ppos") String ppos) {
        List<Rule> rules = ruleService.ruleQuery(ppos);
        return new ResponseBean(200, "succ", rules);
    }

    @PostMapping()
    public ResponseBean ruleInsert(@RequestBody Rule rule) {
        ruleService.ruleInsert(rule);
        return new ResponseBean(200, "succ", null);
    }

    @PutMapping()
    public ResponseBean ruleUpdate(@RequestBody Rule rule) {
        ruleService.ruleUpdate(rule.getPid(), rule.getPpos());
        return new ResponseBean(200, "succ", null);
    }

    @DeleteMapping("/{pid}")
    public ResponseBean ruleDelete(@PathVariable("pid") int pid) {
        ruleService.ruleDelete(pid);
        return new ResponseBean(200, "succ", null);
    }

}