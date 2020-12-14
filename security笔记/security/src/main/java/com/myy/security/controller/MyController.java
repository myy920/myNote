package com.myy.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {



    @RequestMapping(value = "/do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String hello() {
        return "do接口!";
    }

    @RequestMapping(value = "/error", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String hello1() {
        return "error接口!";
    }


}
