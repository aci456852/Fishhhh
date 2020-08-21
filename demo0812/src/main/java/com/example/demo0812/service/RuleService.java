package com.example.demo0812.service;

import com.example.demo0812.DataMapper;
import com.example.demo0812.bean.Rule;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleService {
    @Autowired
    DataMapper dataMapper;

    public List<Rule> listALL(){
        return dataMapper.listALL();
    }

    public List<Rule> ruleQuery(String ppos){
        return dataMapper.ruleQuery(ppos);
    }

    public void ruleInsert(Rule rule){
        dataMapper.ruleInsert(rule);
    }

    public void ruleUpdate(int pid, String ppos){
        dataMapper.ruleUpdate(pid,ppos);
    }

    public void ruleDelete(int pid){
        dataMapper.ruleDelete(pid);
    }

}
