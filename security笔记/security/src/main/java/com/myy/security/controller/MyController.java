package com.myy.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String hello() {
        return "hello接口!";
    }
    @RequestMapping(value = "/error", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String error1() {
        return "error接口!";
    }

    @RequestMapping(value = "/user", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String user() {
        return "user接口!";
    }

    @RequestMapping(value = "/admin", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String admin() {
        return "admin接口!";
    }

    @RequestMapping(value = "/do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String doSome() {
        return "天气不错啊!";
    }

    @RequestMapping(value = "/go", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String doSome1() {
        return "去爬五峰山吧!";
    }

    @RequestMapping(value = "/index", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String index() {
        return "index success";
    }


}
