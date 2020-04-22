package com.pplenty.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yusik on 2020/04/20.
 */
public class TwiceScope implements Scope {

    private static final Map<String, Object> CACHE = new ConcurrentHashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        Object scopedObject = CACHE.get(name);
        if (scopedObject == null) {
            scopedObject = objectFactory.getObject();
            CACHE.put(name, scopedObject);
        } else {
            CACHE.remove(name);
        }
        return scopedObject;
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
