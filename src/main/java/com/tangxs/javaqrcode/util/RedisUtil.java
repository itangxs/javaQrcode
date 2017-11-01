package com.tangxs.javaqrcode.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * @author  tangxs
 */
@Component
public class RedisUtil {

    private static StringRedisTemplate stringRedisTemplate;

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        RedisUtil.stringRedisTemplate = stringRedisTemplate;
    }
    /**
     *   Base (int long float double char string boolean ...)
     */
    public static void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public static void set(String key, String value, long timeout, TimeUnit unit) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    public static String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     *   Object
     */
    public static void setObject(String key, Object value) {
        set(key, JSON.toJSONString(value));
    }

    public static void setObject(String key, Object value, long timeout, TimeUnit unit) {
        set(key, JSON.toJSONString(value), timeout, unit);
    }

    public static Object getObject(String key, Class<?> clazz) {
        return JSONObject.parseObject(get(key), clazz);
    }

    /**
     *   List
     */
    public static void setList(String key, Object value) {
        set(key, JSON.toJSONString(value));
    }

    public static void setList(String key, Object value, long timeout, TimeUnit unit) {
        set(key, JSON.toJSONString(value), timeout, unit);
    }

    public static Object getList(String key, Class<?> clazz) {
        return JSONObject.parseArray(get(key), clazz);
    }

    /**
     *   Set
     */
    public static void setSet(String key, Object value) {
        set(key, JSON.toJSONString(value));
    }

    public static void setSet(String key, Object value, long timeout, TimeUnit unit) {
        set(key, JSON.toJSONString(value), timeout, unit);
    }

    public static Object getSet(String key, Class<?> clazz) {
        return new HashSet<>(JSONObject.parseArray(get(key), clazz));
    }

    public static void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    public static Boolean exist(String key) {
        return stringRedisTemplate.hasKey(key);
    }
}
