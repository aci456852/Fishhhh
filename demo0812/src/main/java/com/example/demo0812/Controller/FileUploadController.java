package com.example.demo0812.Controller;

import com.example.demo0812.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@Controller
public class FileUploadController {
    @Autowired
    private FileService fileService;
    /*
     * 获取file.html页面
     */
    @RequestMapping("upload")
    public String file(){
        return "rules/upload";
    }
    /**
     * 实现文件上传
     * */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileName") MultipartFile uploadfile) {
        if (uploadfile.isEmpty()) {
            return "文件上传失败";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        String format = sdf.format(new Date());
        File file = new File(format);

        String oldName = uploadfile.getOriginalFilename();
        assert oldName != null;
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());

        String filename=file.getAbsolutePath() + File.separator + newName;
        File dest = new File(filename);

        if(!dest.isDirectory()){
            //递归生成文件夹
            dest.mkdirs();
        }
        try {
            uploadfile.transferTo(dest); //保存文件
            fileService.insql(filename);
            return "文件上传成功";
        } catch (IllegalStateException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "文件上传失败";
        }
    }

}