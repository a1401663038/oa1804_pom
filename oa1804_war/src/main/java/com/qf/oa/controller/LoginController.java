package com.qf.oa.controller;

import com.qf.oa.entity.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public  String  login(String  email, String password, Model model){
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            UsernamePasswordToken token =new UsernamePasswordToken(email,password);
           try {
               subject.login(token);
           }catch (Exception e){
               return "login";
           }
        }
        Employee emp=(Employee) subject.getPrincipal();
        model.addAttribute("emp",emp);
        return "index";
    }
}
