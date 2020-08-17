package com.example.demo0812.service;

import com.example.demo0812.DataMapper;
import com.example.demo0812.bean.Rule;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class FileService {

    @Autowired
    DataMapper dataMapper;

    public void insql(String filename) {
        try {
            // 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)
            Workbook book = null;
            try {
                // Excel 2007 + WPS的excle
                book = new XSSFWorkbook(new FileInputStream(filename));
            } catch (Exception ex) {
                // Excel 2003
                book = new HSSFWorkbook(new FileInputStream(filename));
            }
            // 读取表格的第一个sheet页
            Sheet sheet = book.getSheetAt(0);
            // 总行数,从0开始
            int totalRows = sheet.getLastRowNum();
            // 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
            for (int i = 1; i <= totalRows; i++) {
                Row row = sheet.getRow(i);
                if (row == null) {    // 处理空行
                    continue;
                }
                Rule rule = new Rule();
                rule.setPname(row.getCell(0).toString());
                rule.setPcode(row.getCell(1).toString());
                rule.setPpos(row.getCell(2).toString());
                rule.setPtype(row.getCell(3).toString());

                dataMapper.testInsert(rule);
//                int totalCells = row.getLastCellNum() ;
//                for (int j = row.getFirstCellNum(); j < totalCells; j++) {
//                    if(row.getCell(j) == null){ // 处理空列
//                        continue ;
//                    }
//                    // 获取单元格内容
//                    cell = row.getCell(j).toString();
//                    //System.out.print(cell + "\t");
//                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
