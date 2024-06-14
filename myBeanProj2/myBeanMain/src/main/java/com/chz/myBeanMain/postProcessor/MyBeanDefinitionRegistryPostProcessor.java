package com.chz.myBeanMain.postProcessor;

import com.chz.myBeanMain.bean.MainBean2;
import com.chz.myBeanMain.bean.MainBean3;
import com.chz.myBeanMain.bean.MainBean4;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor
{

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException
    {
        log.info("chz >>> MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry():");
        // 修改bean的属性
        BeanDefinition mainBean1 = registry.getBeanDefinition("mainBean1");
        mainBean1.getPropertyValues().add("name", "[mainBean1 - 我被MyBeanDefinitionRegistryPostProcessor改了]");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
    {
        log.info("chz >>> MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory():");
        // 添加一个bean
        MainBean2 mainBean2 = new MainBean2();
        mainBean2.setName(mainBean2.getName() + " - 我是通过MyBeanDefinitionRegistryPostProcessor新加的bean");
        beanFactory.registerSingleton("mainBean2", mainBean2);
    }
}
