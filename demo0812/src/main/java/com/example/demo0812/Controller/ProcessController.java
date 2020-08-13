package com.example.demo0812.Controller;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@Controller
public class ProcessController {

    @RequestMapping("/export")
    public void export(@RequestParam("file") MultipartFile file,
                       HttpServletRequest request, HttpServletResponse response) {
        try {
            // @RequestParam("file") MultipartFile file 是用来接收前端传递过来的文件
            // 1.创建workbook对象，读取整个文档
            InputStream inputStream = file.getInputStream();
            POIFSFileSystem poifsFileSystem = new POIFSFileSystem(inputStream);
            HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
            // 2.读取页脚sheet
            HSSFSheet sheetAt = wb.getSheetAt(0);
            // 3.循环读取某一行
            for (Row row : sheetAt) {
                // 4.读取每一行的单元格
                String stringCellValue = row.getCell(0).getStringCellValue(); // 第一列数据
                String stringCellValue2 = row.getCell(1).getStringCellValue();// 第二列
                // 写多少个具体看大家上传的文件有多少列.....
                // 测试是否读取到数据,及数据的正确性
                System.out.println(stringCellValue);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

