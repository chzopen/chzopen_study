package com.chz.myBeanMain.imports.importSelector;

import com.chz.myBeanMain.MyBeanMainTest2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

@Slf4j
public class BranchCommonImportSelector implements ImportSelector
{
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata)
    {
        log.info("chz >>> BranchCommonImportSelector.selectImports()");
        MyBeanMainTest2.test(annotationMetadata);
        return new String[]{};
    }
}
