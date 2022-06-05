package com.residenthelper.server.service.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author lixiaohui
 * @date 6/2/22
 */
public class CacheableService {
    @Autowired
    protected RedisTemplate redisTemplate;

    @Autowired
    protected StringRedisTemplate stringRedisTemplate;

    public void setRedisCache(String key, Object value, int expire_minutes) {
        redisTemplate.opsForValue().set(key, value, expire_minutes * 60, TimeUnit.SECONDS);
    }

    public void setRedisCache(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getRedisCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void deleteRedisCache(String key) {
        redisTemplate.delete(key);
    }

    public void setStringRedisCache(String key, String valueStr, int expire_minutes) {
        stringRedisTemplate.opsForValue().set(key, valueStr, expire_minutes * 60, TimeUnit.SECONDS);
    }

    public String getStringRedisCache(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 慎用
     * @param matchKey
     * @return keys
     */
    public Set<String> scan(String matchKey) {
        Set<String> keys = (Set<String>) redisTemplate.execute((RedisCallback<Set<String>>) connection -> {

            Set<String> keysTmp = new HashSet<>();
            JdkSerializationRedisSerializer serializationRedisSerializer = new JdkSerializationRedisSerializer();
            Cursor<byte[]> cursor = connection.scan(new ScanOptions.ScanOptionsBuilder().match("*" + matchKey + "*").count(Integer.MAX_VALUE).build());
            while (cursor.hasNext()) {
                keysTmp.add((String)serializationRedisSerializer.deserialize(cursor.next()));
            }
            try {
                cursor.close();
            } catch (IOException e) {

            }
            return keysTmp;

        });
        return keys;
    }
}
