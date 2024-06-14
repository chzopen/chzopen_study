package com.chz.myBeanRegistrar;

import com.chz.myBeanRegistrar.beanRegistrar.MyImportBeanDefinitionRegistrar;
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
