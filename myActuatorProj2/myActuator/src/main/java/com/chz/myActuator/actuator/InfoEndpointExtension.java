package com.chz.myActuator.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@EndpointWebExtension(endpoint = InfoEndpoint.class)
public class InfoEndpointExtension {

    @Autowired
    private InfoEndpoint delegate;

    @ReadOperation
    public Map<String, Object> info()
    {
        Map<String, Object> info = new HashMap<>(delegate.info());
        info.put("chz_new_p", "info: I am new p");          // 加个属性
        return info;
    }

    @ReadOperation
    public Map<String, Object> infoExt(@Selector String name)
    {
        Map<String, Object> info = new HashMap<>(delegate.info());
        info.put(name, "infoExt: I am new p");       // 加个属性
        return info;
    }

}