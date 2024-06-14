package com.chz.myBeanMain.registrar;

import com.chz.myBeanMain.registrar.beanRegistrar.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Import({
        MyImportBeanDefinitionRegistrar.class,                 // 这里使用了 ImportBeanDefinitionRegistrar
})
public @interface EnableBranchRegistrar {
}
