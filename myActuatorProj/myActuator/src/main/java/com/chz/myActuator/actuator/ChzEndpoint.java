package com.chz.myActuator.actuator;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@Endpoint(id = "chzEndpoint")
public class ChzEndpoint {

    private Map<String, Feature> features = new ConcurrentHashMap<>();

    @PostConstruct
    public void init()
    {
        log.info("chz >> ChzEndpoint.<init>()");

        Feature p1Feature = new Feature();
        p1Feature.setEnabled(true);
        p1Feature.setName("p1");
        p1Feature.setValue(1D);
        features.put("p1", p1Feature);

        Feature p2Feature = new Feature();
        p2Feature.setEnabled(true);
        p2Feature.setName("p2");
        p2Feature.setValue(2D);
        features.put("p2", p2Feature);
    }

    @ReadOperation
    public Map<String, Feature> features() {
        log.info("chz >> ChzEndpoint.features()");
        return features;
    }

    @ReadOperation
    public Feature feature(@Selector String name) {
        log.info("chz >> ChzEndpoint.feature(@Selector String name)");
        return features.get(name);
    }

    @WriteOperation
    public void putFeature(@Selector String name, Double value) {
        log.info("chz >> ChzEndpoint.putFeature(@Selector String name, Feature feature)");

        Feature feature = features.get(name);
        if( feature!=null ){
            feature.setValue(value);
        } else {
            feature = new Feature();
            feature.setEnabled(true);
            feature.setName(name);
            feature.setValue(value);
            feature.setTime(LocalDateTime.now());
            features.put(name, feature);
        }
    }

    @DeleteOperation
    public void deleteFeature(@Selector String name) {
        log.info("chz >> ChzEndpoint.deleteFeature(@Selector String name)");
        features.remove(name);
    }

    @Getter
    @Setter
    public class Feature
    {
        private Boolean enabled;
        private String name;
        private Double value;
        private LocalDateTime time = LocalDateTime.now();
    }

}