package com.chz.myBeanRegistrar.controller;

import com.chz.myBeanRegistrar.annotation.MyRegistrarAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@MyRegistrarAnnotation
@ResponseBody
@RequestMapping("/branch/registrar")
public class BranchRegistrarController {

    public BranchRegistrarController()
    {
        log.info("chz >>> BranchRegistrarController.<init>()");
    }

    @GetMapping("/test1")
    public String test1() {
        return "test1: BranchRegistrarController";
    }

}