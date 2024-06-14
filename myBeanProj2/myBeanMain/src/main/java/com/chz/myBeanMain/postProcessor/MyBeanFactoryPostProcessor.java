package com.chz.myBeanMain.postProcessor;

import com.chz.myBeanMain.bean.MainBean3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor
{
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
    {
        log.info("chz >>> MyBeanFactoryPostProcessor.postProcessBeanFactory():");
        // 添加一个bean
        MainBean3 mainBean3 = new MainBean3();
        mainBean3.setName(mainBean3.getName() + " - 我是通过MyBeanFactoryPostProcessor新加的bean");
        beanFactory.registerSingleton("mainBean3", mainBean3);
    }
}
