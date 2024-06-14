package com.chz.myBeanMain.registrar.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
public @interface MyRegistrarAnnotation {
}
