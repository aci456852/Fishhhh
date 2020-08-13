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

    //查询
    List<Rule> testQuery(@Param("pcode")String pcode);

    //插入
    void testInsert(Rule rule);

    //更新
    void testUpdate(@Param("pname")String pname, @Param("ppos")String ppos);

    //删除
    void testDelete(String pname);
}
