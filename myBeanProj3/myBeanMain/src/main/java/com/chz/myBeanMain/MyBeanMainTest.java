package com.chz.myBeanMain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = {"classpath:my_beans.xml"})
@SpringBootApplication
public class MyBeanMainTest {

    public static void main(String[] args) {
        SpringApplication.run(MyBeanMainTest.class, args);
    }

}