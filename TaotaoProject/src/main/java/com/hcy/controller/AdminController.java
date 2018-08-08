package com.hcy.controller;

import com.hcy.bean.Admin;
import com.hcy.service.AdminService;
import com.util.CodeUtil;
import com.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 好好学习 不做咸鱼
 * Created by Hcy on 18/8/7.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminServiceImpl;


    // 获得code的值
    private String code_temp;

    @RequestMapping(value = "/dologin.do")
    @ResponseBody
    public String dologin(@RequestBody Map<String, String> map, HttpServletRequest request) {
        System.out.println(map);
        List<Admin> adminList = adminServiceImpl.findByLoginnameAndPassword(map.get("username"), MD5Util.encode2hex(map.get("password")));

        if (adminList.size()>0){
            Admin admin = adminList.get(0);
            System.out.println(admin);
            HttpSession session = request.getSession();
            session.setAttribute("admin",admin);
            return "true";
        }else{
            return "false";
        }
    }

    @RequestMapping("/toMain.do")
    public String toMain(){
        return "main";
    }

    @RequestMapping("showCode.do")
    public void showCode(HttpServletResponse resp) {
        Map<String, Object> codeMap = CodeUtil.generateCodeAndPic();

        code_temp = String.valueOf(codeMap.get("code"));

        // 禁止图像缓存。
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", -1);
        resp.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos;
        try {
            sos = resp.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
            sos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 用于检查验证码输入是否正确
    @RequestMapping("codeCheck.do")
    @ResponseBody
    public String codeCheck(String code){

        System.out.println(code_temp+"!!!!!!!!!!!!!!!!");
        System.out.println(code+">????????????????");
        if (code.toLowerCase().equals(code_temp.toLowerCase())){
            System.out.println(1);
            return "true";
        }else{
            System.out.println(2);

            return "false";
        }
    }



}
