package com.example.demo0812;

import com.example.demo0812.bean.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Demo0812ApplicationTests {

    @Autowired
    private DataMapper dataMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testHello(){
        System.out.println("Hello World!");
    }


    @Test
    void testQuery()
    {
        System.out.println("test_query...");
        String pcode="GZ01010101";
        List<Rule> RuleList =dataMapper.testQuery(pcode);
        Rule.Print(RuleList);
    }
    @Test
    void testInsert()
    {
        System.out.println("test_insert...");
        Rule rule = new Rule();
        rule.setPname("规则01");
        rule.setPcode("GZ01010101");
        rule.setPpos("ERP.人力资源.用户.填写规则");
        rule.setPtype("风险");
        dataMapper.testInsert(rule);
    }

    @Test
    void testUpdate()
    {
        System.out.println("test_update...");
        dataMapper.testUpdate("规则01", "改成其他的");
    }

    @Test
    void testDelete()
    {
        System.out.println("test_delete...");
        dataMapper.testDelete("规则01");
    }

}
