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

    public List<Rule> ruleQuery(String pcode){
        return dataMapper.ruleQuery(pcode);
    }

    public void ruleInsert(Rule rule){
        dataMapper.ruleInsert(rule);
    }

    public void ruleUpdate(String pname, String ppos){
        dataMapper.ruleUpdate(pname,ppos);
    }

    public void ruleDelete(String pname){
        dataMapper.ruleDelete(pname);
    }

}
