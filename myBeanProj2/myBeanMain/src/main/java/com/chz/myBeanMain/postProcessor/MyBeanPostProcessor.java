package com.chz.myBeanMain.postProcessor;

import com.chz.myBeanMain.bean.IMainBean4;
import com.chz.myBeanMain.bean.MainBean4;
import com.chz.myBeanMain.bean.MainBean4Proxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyBeanPostProcessor implements BeanPostProcessor
{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("chz >>> MyBeanPostProcessor.postProcessBeforeInitialization(): {}", beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
    {
        log.info("chz >>> MyBeanPostProcessor.postProcessAfterInitialization(): {}", beanName);
        if( (bean instanceof IMainBean4) && !(bean instanceof MainBean4Proxy)){
            bean = new MainBean4Proxy((MainBean4)bean);
        }
        return bean;
    }
}
