package com.chz.myBeanMain.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Setter
// @Component
public class MainBean3 {

    public MainBean3()
    {
        log.info("chz >>> MainBean3.<init>()");
    }

    private String name = "MainBean3";

}
