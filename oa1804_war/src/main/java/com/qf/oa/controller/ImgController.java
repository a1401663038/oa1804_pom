package com.qf.oa.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@Controller
@RequestMapping("/img")
public class ImgController {
    @Value("${uploadPath}")
    private String uploadPath;

    @RequestMapping("/upload")
    @ResponseBody
    public  String imgUploader(MultipartFile file){
        System.out.println("上传路径"+uploadPath);
        System.out.println("上传文件的名称"+file.getOriginalFilename());
        System.out.println("上传文件的大小"+file.getSize());

        InputStream in=null;
        OutputStream out=null;
        try {
            in=file.getInputStream();
            String path=uploadPath+"/"+ UUID.randomUUID().toString();
            out=new FileOutputStream(path);
            IOUtils.copy(in,out);
            return "{\"fileuploader\":\"" + path + "\"}";

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in !=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "null";



    }

    @RequestMapping("/getImg")
    public void getImg(String path, HttpServletResponse response){
        InputStream in=null;
        OutputStream out=null;
        try {
            in = new FileInputStream(path);
            out=response.getOutputStream();

            IOUtils.copy(in,out);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
