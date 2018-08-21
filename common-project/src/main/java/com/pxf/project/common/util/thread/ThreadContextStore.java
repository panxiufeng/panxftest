package com.pxf.project.common.util.thread;


import com.alibaba.ttl.TransmittableThreadLocal;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import java.util.Map;

public class ThreadContextStore {
    private volatile ThreadContextStore threadContextStore;
    private TransmittableThreadLocal<Map<String, Object>> threadContext = new TransmittableThreadLocal();

    private ThreadContextStore() {
    }

    public static synchronized ThreadContextStore getInstance() {
        return new ThreadContextStore();
    }

    public synchronized void set(String key, Object o) {
        Map<String, Object> map = (Map)this.threadContext.get();
        if (Objects.equal((Object)null, map)) {
            map = Maps.newHashMap();
        }

        ((Map)map).put(key, o);
        this.threadContext.set(map);
    }

    public synchronized void removeKey(String key) {
        Map<String, Object> map = (Map)this.threadContext.get();
        if (Objects.equal((Object)null, map)) {
            map = Maps.newHashMap();
        }

        ((Map)map).remove(key);
        this.threadContext.set(map);
    }

    public synchronized Object get(String key) {
        Map<String, Object> map = (Map)this.threadContext.get();
        return Objects.equal((Object)null, map) ? null : map.get(key);
    }

    public synchronized void clean() {
        Map<String, Object> map = (Map)this.threadContext.get();
        if (!Objects.equal((Object)null, map)) {
            map.clear();
            this.threadContext.set(map);
        }

    }
}
