package com.Caching.config;

import com.Caching.cache.CacheService;
import com.Caching.cache.CacheStore;
import com.Caching.service.DataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public CacheStore cacheStore(){
        return new CacheStore();
    }

    @Bean
    public CacheService cacheService() {
        return new CacheService(cacheStore(), 60_000);
    }

    @Bean
    public DataService dataService(){
        return new DataService();
    }
}
