package com.chz.myBeanMain;

import com.chz.myBeanMain.annotations.Annotation1;
import com.chz.myBeanMain.annotations.Annotation2;
import com.chz.myBeanMain.annotations.Annotation3;
import com.chz.myBeanMain.imports.EnableBranchImportSelector;
import com.chz.myBeanMain.registrar.EnableBranchRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Annotation1(name = "at MyBeanMainTest: Annotation1-name")
@Annotation2(name = "at MyBeanMainTest: Annotation2-name")
@EnableBranchImportSelector
@EnableBranchRegistrar                  // 这里使用了@ImportBeanDefinitionRegistrar
@SpringBootApplication
public class MyBeanMainTest {

    @Annotation1(name = "at main() method")
    public static void main(String[] args) {
        SpringApplication.run(MyBeanMainTest.class, args);
    }

    @Annotation1(name = "at test1() method")
    public static void test1()
    {
    }

    @Annotation2(name = "at test2() method")
    public static void test2()
    {
    }

    @Annotation3(name = "at test3() method")
    public static void test3()
    {
    }

}