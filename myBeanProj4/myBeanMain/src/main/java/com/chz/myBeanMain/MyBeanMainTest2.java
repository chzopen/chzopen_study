package com.chz.myBeanMain;

import com.chz.myBeanMain.annotations.Annotation1;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;

public class MyBeanMainTest2 {

    public static void main(String[] args) throws Exception
    {
        // 生成【MyBeanMainTest.class】的【AnnotationMetadata】
        AnnotationMetadata annotationMetadata = AnnotationMetadata.introspect(MyBeanMainTest.class);
        MyBeanMainTest2.test(annotationMetadata);
    }

    public static void test(AnnotationMetadata annotationMetadata)
    {

        StandardAnnotationMetadata standardAnnotationMetadata = (StandardAnnotationMetadata)annotationMetadata;

        // 获取注解【Annotation1】的所有属性值
        System.out.println("################################################################");
        Map<String, Object> annotationAttributes = standardAnnotationMetadata.getAnnotationAttributes(Annotation1.class.getName(), false);
        System.out.println(annotationAttributes);

        // 合并所有的注解
        MergedAnnotations mergedAnnotations = standardAnnotationMetadata.getAnnotations();

        // 获取注解【Annotation1】上的【name】属性值
        System.out.println("################################################################");
        MergedAnnotation<Annotation1> annotation1MergedAnnotation = mergedAnnotations.get(Annotation1.class);
        String name = annotation1MergedAnnotation.getString("name");
        System.out.println(name);

        // 获取主程序类的所有注解名(去重)
        System.out.println("################################################################");
        Set<String> annotationTypes = standardAnnotationMetadata.getAnnotationTypes();
        System.out.println(annotationTypes);

        // 列出【MyBeanMainTest】类的所有注解，包括注解的注解
        System.out.println("################################################################");
        for( MergedAnnotation<Annotation> mergedAnnotation : mergedAnnotations ){
            System.out.println(mergedAnnotation.getType());
        }

        // 获取被【Annotation1】注解的所有方法
        System.out.println("################################################################");
        Set<MethodMetadata> annotatedMethods = standardAnnotationMetadata.getAnnotatedMethods(Annotation1.class.getName());
        for( MethodMetadata methodMetadata : annotatedMethods ){
            System.out.println("-----------------------");
            System.out.println(methodMetadata.getMethodName());
            System.out.println(methodMetadata.getAnnotationAttributes(Annotation1.class.getName()));
        }
    }


}