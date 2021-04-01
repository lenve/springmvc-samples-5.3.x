package org.javaboy.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@RestController
public class FileUploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");

    @PostMapping("/upload")
    public String fileUpload(MultipartFile file, HttpServletRequest req) {
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("/img") + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        try {
            file.transferTo(new File(folder, newName));
            return req.getScheme() + "://" + req.getRemoteHost() + ":" + req.getServerPort() + "/img" + format + newName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @PostMapping("/upload2")
    public String fileUpload2(HttpServletRequest req) throws IOException, ServletException {
        StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
        MultipartFile file = resolver.resolveMultipart(req).getFile("file");
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("/img") + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        try {
            file.transferTo(new File(folder, newName));
            return req.getScheme() + "://" + req.getRemoteHost() + ":" + req.getServerPort() + "/img" + format + newName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @PostMapping("/upload4")
    public String fileUpload4(HttpServletRequest req) throws IOException, ServletException {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(req.getServletContext());
        MultipartHttpServletRequest multipartHttpServletRequest = resolver.resolveMultipart(req);
        MultipartFile file = resolver.resolveMultipart(req).getFile("file");
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("/img") + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        try {
            file.transferTo(new File(folder, newName));
            return req.getScheme() + "://" + req.getRemoteHost() + ":" + req.getServerPort() + "/img" + format + newName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @PostMapping("/upload3")
    public String fileUpload3(HttpServletRequest req) throws IOException, ServletException {
        String other_param = req.getParameter("other_param");
        System.out.println("other_param = " + other_param);
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("/img") + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        Part filePart = req.getPart("file");
        String oldName = filePart.getSubmittedFileName();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        try {
            filePart.write(realPath + newName);
            return req.getScheme() + "://" + req.getRemoteHost() + ":" + req.getServerPort() + "/img" + format + newName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
