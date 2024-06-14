package com.chz.myBeanMain;

import com.chz.myBeanMain.bean.NotAnnotatedBean;
import com.chz.myBeanRegistrar.EnableBranchRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(NotAnnotatedBean.class)         // 这里使用了@Import
@EnableBranchRegistrar                  // 这里使用了@ImportBeanDefinitionRegistrar
@SpringBootApplication
public class MyBeanMainTest {

    public static void main(String[] args) {
        SpringApplication.run(MyBeanMainTest.class, args);
    }

}