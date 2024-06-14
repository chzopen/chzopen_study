//package com.chz.myBeanMain.imports.importSelector;
//
//import com.chz.myBeanMain.imports.bean.BranchDeferredBean;
//import com.chz.myBeanMain.imports.bean.BranchDeferredImportConfiguration;
//import com.chz.myBeanMain.imports.controller.BranchDeferredController;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.DeferredImportSelector;
//import org.springframework.core.type.AnnotationMetadata;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Slf4j
//public class BranchDeferredImportSelector implements DeferredImportSelector
//{
//    @Override
//    public String[] selectImports(AnnotationMetadata annotationMetadata)
//    {
//        log.info("chz >>> BranchDeferredImportSelector.selectImports()");
//        return new String[]{
//                BranchDeferredBean.class.getName(),
//                BranchDeferredController.class.getName(),
//                BranchDeferredImportConfiguration.class.getName(),
//        };
//    }
//
//    @Override
//    public Class<? extends Group> getImportGroup() {
//        log.info("chz >>> BranchDeferredImportSelector.getImportGroup()");
//        return DeferredImportSelectorBeanGroup.class;
//    }
//
//    private static class DeferredImportSelectorBeanGroup implements Group {
//
//        private final List<Entry> instanceImports = new ArrayList<>();
//
//        @Override
//        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
//            log.info("chz >>> DeferredImportSelectorBeanGroup.process()");
//            for (String importClassName : selector.selectImports(metadata)) {
//                this.instanceImports.add(new Entry(metadata, importClassName));
//            }
//        }
//
//        @Override
//        public Iterable<Entry> selectImports() {
//            log.info("chz >>> DeferredImportSelectorBeanGroup.selectImports()");
//            return instanceImports;
//        }
//    }
//}
