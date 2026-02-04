package com.Caching.service;

import org.springframework.stereotype.Service;

@Service
public class DataService {
    public String fetchData(String key){
        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return  "Data for key: " + key + " (loaded at " + System.currentTimeMillis() + ")";
    }
}
