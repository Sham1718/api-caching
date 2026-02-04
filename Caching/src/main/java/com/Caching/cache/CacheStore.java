package com.Caching.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheStore {
    private final Map<String,CacheEntry<?>> store=new ConcurrentHashMap<>();

    public Object get(String key){
        CacheEntry<?> entry =store.get(key);

        if (entry==null){
            return null;
        }
        if (entry.isExpired()){
            store.remove(key);
            return null;
        }

        return entry.getValue();
    }

    public void  put(String key,CacheEntry<?> entry){
        store.put(key,entry);
    }
    public void evict(String key){
        store.remove(key);
    }

    public void clear(){
        store.clear();
    }
}
