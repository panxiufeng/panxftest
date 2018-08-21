package com.pxf.project.common.util.thread;


import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import java.util.Map;

public abstract class AbstractThreadContext {
    public AbstractThreadContext() {
    }

    protected abstract ThreadLocal<Map<String, Object>> getThreadContext();

    public void set(String key, Object o) {
        ThreadLocal<Map<String, Object>> threadContext = this.getThreadContext();
        Map<String, Object> map = (Map)threadContext.get();
        if (Objects.equal((Object)null, map)) {
            map = Maps.newHashMap();
        }

        ((Map)map).put(key, o);
        if (o instanceof String) {
            ((Map)map).put((String)o, Thread.currentThread().getName());
        }

        threadContext.set(map);
    }

    public void removeKey(String key) {
        ThreadLocal<Map<String, Object>> threadContext = this.getThreadContext();
        Map<String, Object> map = (Map)threadContext.get();
        if (Objects.equal((Object)null, map)) {
            map = Maps.newHashMap();
        }

        ((Map)map).remove(key);
        threadContext.set(map);
    }

    public Object get(String key) {
        ThreadLocal<Map<String, Object>> threadContext = this.getThreadContext();
        Map<String, Object> map = (Map)threadContext.get();
        return Objects.equal((Object)null, map) ? null : map.get(key);
    }

    public void clean() {
        ThreadLocal<Map<String, Object>> threadContext = this.getThreadContext();
        Map<String, Object> map = (Map)threadContext.get();
        if (!Objects.equal((Object)null, map)) {
            map.clear();
            threadContext.set(map);
        }

    }
}
