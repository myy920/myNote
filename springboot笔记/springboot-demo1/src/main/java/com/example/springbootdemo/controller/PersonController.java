package com.example.springbootdemo.controller;


import com.example.springbootdemo.entity.Person;
import com.example.springbootdemo.entity.system.ReturnData;
import com.example.springbootdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/add")
    @ResponseBody
    public ReturnData add(String name, int age, String hobby){
        ReturnData returnData = new ReturnData();
        int add = personService.add(name, age, hobby);
        if (add == 1){
            returnData.setSuccess(true);
            returnData.setMessage("添加成功!");
        }else {
            returnData.setSuccess(false);
            returnData.setMessage("添加失败: 用户名已存在!");
        }
        return returnData;
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public ReturnData selectAll(){
        ReturnData returnData = new ReturnData();
        List<Person> personList = personService.selectAll();
        returnData.setObject(personList);
        return returnData;
    }
}
