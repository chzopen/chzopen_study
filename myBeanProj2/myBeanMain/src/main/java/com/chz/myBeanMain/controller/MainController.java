package com.chz.myBeanMain.controller;

import com.chz.myBeanMain.bean.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired(required = false)
    private MainBean1 mainBean1;

    @Autowired(required = false)
    private MainBean2 mainBean2;

    @Autowired(required = false)
    private MainBean3 mainBean3;

    @Autowired(required = false)
    private IMainBean4 mainBean4;

    @GetMapping("/mainBean1")
    public String mainBean1() {
        return "mainBean1: " + mainBean1.getName();
    }

    @GetMapping("/mainBean2")
    public String mainBean2() {
        return "mainBean2: " + mainBean2.getName();
    }

    @GetMapping("/mainBean3")
    public String mainBean3() {
        return "mainBean3: " + mainBean3.getName();
    }

    @GetMapping("/mainBean4")
    public String mainBean4() {
        return "mainBean4: " + mainBean4.getName();
    }

}