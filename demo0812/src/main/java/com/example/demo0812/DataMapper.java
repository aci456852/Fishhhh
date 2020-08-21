package com.example.demo0812;

import java.util.List;
import java.util.Map;

import com.example.demo0812.bean.Rule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//映射Sql，定义接口
@Mapper
@Component
public interface DataMapper {

    //显示
    List<Rule> listALL();

    //查询
    List<Rule> ruleQuery(@Param("ppos")String ppos);

    //插入
    void ruleInsert(Rule rule);

    //更新
    void ruleUpdate(@Param("pid")int pid, @Param("ppos")String ppos);

    //删除
    void ruleDelete(int pid);
}
