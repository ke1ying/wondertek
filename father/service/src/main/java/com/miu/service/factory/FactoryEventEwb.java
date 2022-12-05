package com.miu.service.factory;

import com.miu.service.FactoryService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author keying
 */
@Component
public class FactoryEventEwb {

    private static final Map<String, FactoryService> concurrentHashMap = new ConcurrentHashMap<>();

    public FactoryEventEwb(List<FactoryService> list) {
        for (FactoryService subHandler : list) {
            if (StringUtils.isEmpty(subHandler.getType())) {
              continue;
            }
            concurrentHashMap.put(subHandler.getType(), subHandler);
        }
    }

    public static FactoryService getByType(String type) {
        if (Objects.isNull(type)) {
            return null;
        }
        return concurrentHashMap.get(type);
    }

}