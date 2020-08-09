package com.shri.ruleengine.context;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class AppRequestContext {

    private String locale = "en_US"; //TBD where this would come from
    private String tenantId;
    private String trackingId;
    private LocalDateTime startTime = LocalDateTime.now();
    private LocalDateTime endTime;
    private String taskType;
    //private RulesConfig config = new RulesConfig();
    private String tenant;
    private Map<String, Object> customContextAttributeMap = new HashMap<>();

    public void addCustomAttribute(String key, Object value) {
        customContextAttributeMap.putIfAbsent(key, value);
    }
}
