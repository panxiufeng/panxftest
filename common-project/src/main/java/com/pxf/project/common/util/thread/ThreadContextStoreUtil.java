package com.pxf.project.common.util.thread;


import java.util.Map;

public class ThreadContextStoreUtil extends AbstractThreadContext {
    private static ThreadLocal<Map<String, Object>> threadContext = new ThreadLocal();
    private static volatile ThreadContextStoreUtil app = null;

    private ThreadContextStoreUtil() {
    }

    public static synchronized ThreadContextStoreUtil getInstance() {
        if (app == null) {
            Class var0 = ThreadContextStoreUtil.class;
            synchronized(ThreadContextStoreUtil.class) {
                if (app == null) {
                    app = new ThreadContextStoreUtil();
                }
            }
        }

        return app;
    }

    protected ThreadLocal<Map<String, Object>> getThreadContext() {
        return threadContext;
    }
}

