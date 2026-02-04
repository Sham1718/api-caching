package com.Caching.cache;

import lombok.Getter;

public class CacheEntry <T>{
    @Getter
    private final T value;
    private final long createdAt;
    private final long ttlInMillis;

    public CacheEntry(T value, long ttlInMillis) {
        this.value = value;
        this.createdAt = System.currentTimeMillis();
        this.ttlInMillis = ttlInMillis;
    }

    public boolean isExpired(){
        return System.currentTimeMillis()-createdAt>= ttlInMillis;
    }
}
