package com.chz.myBeanMain.annotations;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Annotation1 {

    String name() default "Annotation1-name";
    String p1() default "Annotation1-p1";

}
