package com.Caching.controller;

import com.Caching.cache.CacheService;
import com.Caching.service.DataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    private final DataService dataService;
    private final CacheService cacheService;

    public DataController(DataService dataService, CacheService cacheService) {
        this.dataService = dataService;
        this.cacheService = cacheService;
    }

    @GetMapping("/data/{key}")
    public Object getData(@PathVariable String key){
        return cacheService.get(
                key,
                ()->dataService.fetchData(key)
        );
    }
}
