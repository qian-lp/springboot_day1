package com.baizhi.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping("upload")
    public String upload(MultipartFile bb, HttpServletRequest request) throws IOException {
        System.out.println("进来了");
        String originalName = bb.getOriginalFilename();
        String realPath = request.getSession().getServletContext().getRealPath("files");
        bb.transferTo(new File(realPath, originalName));
        return "index";
    }

    @RequestMapping("download")
    public String download(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(fileName);
        String realPath = request.getSession().getServletContext().getRealPath("files");
        //后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String mimeType = request.getSession().getServletContext().getMimeType(suffix);
        System.out.println(mimeType);
        response.setContentType(mimeType + ";charset=UTF-8");
        FileInputStream is = new FileInputStream(new File(realPath, fileName));
        ServletOutputStream os = response.getOutputStream();
        response.setHeader("content-disposition", "attachment;fileName" + URLEncoder.encode(fileName, "UTF-8"));
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);


        return null;
    }
}
