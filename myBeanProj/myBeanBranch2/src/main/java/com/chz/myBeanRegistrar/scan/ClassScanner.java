package com.chz.myBeanRegistrar.scan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ClassScanner {

    private static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    private String basePackage;
    private ClassLoader classLoader;
    private Matcher matcher;

    public ClassScanner(String basePackage, Matcher matcher)
    {
        this(basePackage, matcher, null);
    }

    public ClassScanner(String basePackage, Matcher matcher, ClassLoader classLoader)
    {
        this.basePackage = basePackage;
        this.classLoader = classLoader!=null ? classLoader : this.getClass().getClassLoader();
        this.matcher = matcher;
    }

    public List<Class<?>> scan() throws IOException {
        List<Class<?>> candidates = new ArrayList<>();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + convertPath(basePackage) + '/' + DEFAULT_RESOURCE_PATTERN;
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        MetadataReaderFactory readerFactory = new SimpleMetadataReaderFactory(resourceLoader);
        Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(packageSearchPath);
        for (Resource resource : resources) {
            Class<?> clazz = transformToClass(readerFactory.getMetadataReader(resource).getClassMetadata().getClassName());
            if( matcher.match(clazz) ) {
                candidates.add(clazz);
            }
        }
        return candidates;
    }

    private Class<?> transformToClass(String className) {
        Class<?> clazz = null;
        try {
            clazz = ClassUtils.forName(className, classLoader);
        } catch (ClassNotFoundException e) {
            log.info("未找到指定类", className, e);
        } catch (NoClassDefFoundError e) {
            log.info("未找到指定类", className, e);
            throw e;
        }
        return clazz;
    }

    private String convertPath(String path) {
        return StringUtils.replace(path, ".", "/");
    }

    public interface Matcher
    {
        boolean match(Class<?> clazz);
    }

}
