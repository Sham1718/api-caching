package com.Caching.cache;

import java.util.function.Supplier;

public class CacheService {
    private final CacheStore store;
    private final long defaultTtlInMillis;

    public CacheService(CacheStore store, long defaultTtlInMillis) {
        this.store = store;
        this.defaultTtlInMillis = defaultTtlInMillis;
    }

    public Object get(String key, Supplier<Object> dataLoader){
        Object cacheValue=store.get(key);

        if (cacheValue!=null){
            return cacheValue;
        }
        Object value=dataLoader.get();

        store.put(key,new CacheEntry<>(value,defaultTtlInMillis));

        return value;
    }

    public void evict(String key){
        store.evict(key);
    }

    public void clear(){
        store.clear();
    }
}
