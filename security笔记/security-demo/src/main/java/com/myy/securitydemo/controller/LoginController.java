package com.myy.securitydemo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/mylogin")
    @ResponseBody
    public String login(String username, String password, HttpServletResponse response, HttpSession session) {
        session.setAttribute("user", username);
        response.addCookie(new Cookie("user", username));
        return "login Success";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpServletResponse response,HttpSession session) {
        session.removeAttribute("user");
        response.addCookie(new Cookie("user",null));
        return "logout Success";
    }

    @RequestMapping("/doSome")
    @ResponseBody
    public String doSome(){
        System.out.println("doSome");
        return "doSome";
    }

}
