package com.chz.myBeanMain.annotations;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Annotation1(name = "at Annotation2: Annotation1-name")
public @interface Annotation2 {

    String name() default "Annotation2-name";

}
