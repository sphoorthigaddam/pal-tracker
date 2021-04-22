package io.pivotal.pal.tracker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    private final String port;
    private final String memoryLimit;
    private final String instanceIndex;
    private final String instanceAddr;

    public EnvController(@Value("${port:NOT SET}") String port, @Value("${memory.limit: NOT SET}") String memoryLimit, @Value("${cf.instance.index: NOT SET}") String instanceIndex, @Value("${cf.instance.addr: NOT SET}") String instanceAddr) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.instanceIndex = instanceIndex;
        this.instanceAddr = instanceAddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> envMap = new HashMap<>();
        envMap.put("PORT", this.port);
        envMap.put("MEMORY_LIMIT", this.memoryLimit);
        envMap.put("CF_INSTANCE_INDEX", this.instanceIndex);
        envMap.put("CF_INSTANCE_ADDR", this.instanceAddr);

        return envMap;

    }
}
