package com.ysan.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @description
 * @since 2023/2/2 9:25
 **/
@Component
@RequestMapping("/file")
public class FileHandler {
    /**
     * 文件是以二进制流传输的
     * @param img
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("img") MultipartFile img, HttpServletRequest request){
        if (img.getSize()>0){
            // 是获取的的tamcat的路径，部署项目后相当于项目的路径。
            String path = request.getSession().getServletContext().getRealPath("file");
            String filename = img.getOriginalFilename();
            File descFile=new File(path, filename);
            try {
                // 直接写入文件
                img.transferTo(descFile);
                request.setAttribute("src", "/file/"+filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "upload";
    }


    @PostMapping("/uploads")
    public String uploads(@RequestParam("imgs") MultipartFile[] imgs,HttpServletRequest request){
        List<String> pathList=new ArrayList<>();
        for (MultipartFile img:imgs){
            if (img.getSize()>0){
                String path = request.getSession().getServletContext().getRealPath("file");
                String filename = img.getOriginalFilename();
                File descFile=new File(path, filename);
                try {
                    img.transferTo(descFile);
                    pathList.add("/file/"+filename);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("pathList", pathList);
        return "upload";
    }

    /**
     *
     * @return void
     * @since 2023/2/2 9:51
     * @author Administrator
     * @description 根据文件名字进行下载
     */
    @GetMapping("/download")
    public void download(String fileName, HttpServletRequest request, HttpServletResponse response) {
        if (fileName != null) {
            String path = request.getSession().getServletContext().getRealPath("file");
            File file = new File(path, fileName);
            OutputStream out = null;
            if (file.exists()) {
                // 设置下载文件
                response.setContentType("applicationContext/force-download");
                // 设置文件名
                response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                try {
                    out = response.getOutputStream();
                    out.write(FileUtils.readFileToByteArray(file));
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (out != null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}


