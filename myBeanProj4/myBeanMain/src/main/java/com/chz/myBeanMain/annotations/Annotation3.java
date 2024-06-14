package com.chz.myBeanMain.annotations;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Annotation3 {

    String name() default "Annotation2-name";

}
