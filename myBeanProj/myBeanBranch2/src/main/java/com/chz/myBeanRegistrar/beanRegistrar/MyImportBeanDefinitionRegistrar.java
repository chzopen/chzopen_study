package com.chz.myBeanRegistrar.beanRegistrar;

import com.chz.myBeanRegistrar.EnableBranchRegistrar;
import com.chz.myBeanRegistrar.annotation.MyRegistrarAnnotation;
import com.chz.myBeanRegistrar.controller.BranchRegistrarController;
import com.chz.myBeanRegistrar.scan.MyRegistrarScanner;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.io.IOException;
import java.util.List;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry,
                                        BeanNameGenerator importBeanNameGenerator)
    {
        try {
            MyRegistrarScanner scanner = new MyRegistrarScanner(EnableBranchRegistrar.class.getPackageName());
            List<Class<?>> targetClassList = scanner.scan();
            for( Class<?> klass : targetClassList ){
                GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
                beanDefinition.setBeanClass(klass);
                registry.registerBeanDefinition(klass.getName(), beanDefinition);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args)
    {
        MyRegistrarAnnotation annotation = BranchRegistrarController.class.getAnnotation(MyRegistrarAnnotation.class);
        System.out.println(annotation);
    }

}
