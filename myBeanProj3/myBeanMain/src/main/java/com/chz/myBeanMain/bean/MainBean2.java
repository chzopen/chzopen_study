package com.chz.myBeanMain.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Setter
//@Component
public class MainBean2 {

    public MainBean2()
    {
        log.info("chz >>> MainBean1.<init>()");
    }

    private String name = "MainBean2";

}
