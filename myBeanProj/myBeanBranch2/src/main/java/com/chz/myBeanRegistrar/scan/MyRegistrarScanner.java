package com.chz.myBeanRegistrar.scan;


import com.chz.myBeanRegistrar.annotation.MyRegistrarAnnotation;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.List;

public class MyRegistrarScanner {

    private ClassScanner classScanner;

    public MyRegistrarScanner(String basePackage){
        classScanner = new ClassScanner(basePackage, new MoMatcher());
    }

    public MyRegistrarScanner(String basePackage, ClassLoader classLoader){
        classScanner = new ClassScanner(basePackage, new MoMatcher(), classLoader);
    }

    public List<Class<?>> scan() throws IOException {
        return (List<Class<?>>)(Object)classScanner.scan();
    }

    private static class MoMatcher implements ClassScanner.Matcher
    {
        @Override
        public boolean match(Class<?> clazz) {
            return isAbstract(clazz)==false && clazz.getAnnotation(MyRegistrarAnnotation.class)!=null;
        }
    }

    public static boolean isAbstract(Class<?> clazz)
    {
        return Modifier.isAbstract(clazz.getModifiers());
    }

//    public static void main(String[] args) throws IOException {
//        MyRegistrarScanner myRegistrarScanner = new MyRegistrarScanner("com.yingzi.cube.sdk.v2");
//        List<Class<? extends IMo>> moClassList = myRegistrarScanner.scan();
//        System.out.println(moClassList);
//
//        List<JSONObject> moInstanceList = moClassList.stream().map(x -> {
//            try {
//                IMo mo = x.newInstance();
//                return mo.toFormatJSONObject();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }).collect(Collectors.toList());
//        System.out.println(moInstanceList);
//    }

}
