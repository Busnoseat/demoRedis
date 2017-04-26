package com.busnoseat.redis;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.*;

/**
 * The type RedisUtil.
 *
 * @author xubo
 * @Description:
 * @Date 2017/4/24
 */
public class RedisUtil {
    private static RedisTemplate<String, Object> template;

    public RedisUtil() {
    }

    public static BoundListOperations<String, Object> list(String listName) {
        return template.boundListOps(listName);
    }

    public static BoundHashOperations<String, String, Object> hash(String hashName) {
        return template.boundHashOps(hashName);
    }

    public static BoundSetOperations<String, Object> set(String setName) {
        return template.boundSetOps(setName);
    }

    public static BoundZSetOperations<String, Object> zset(String zsetName) {
        return template.boundZSetOps(zsetName);
    }

    public static BoundValueOperations<String, Object> value(String key) {
        return template.boundValueOps(key);
    }

    public static void remove(String key) {
        template.delete(key);
    }

    public static void increment(String key, long value) {
        if(StringUtils.isBlank(value(key).get(0L, -1L))) {
            value(key).increment(0L);
        }

        value(key).increment(value);
    }

    static {
        if(template == null) {
            template = (RedisTemplate)SpringUtil.getBean("redisTemplate");
        }

    }
}