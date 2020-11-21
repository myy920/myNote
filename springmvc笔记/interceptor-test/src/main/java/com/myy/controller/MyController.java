package com.myy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping(value = "/doSome",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String doSome(){
        System.out.println("url目标方法doSome()执行!");
        return "成功!";
    }
}
