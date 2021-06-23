package com.residenthelper.server.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lee
 * @Date: 6/21/21
 * @Desc: 处理缓存
 */
public abstract class CacheService {
    private Map<String, Object> cache = new HashMap<>();


    public void saveRedisCache(String cacheKey, Object o, int expireMinutes){
        cache.put(cacheKey, o);
    }

    public Object getRedisCache(String cacheKey){
        return cache.get(cacheKey);
    }
}
