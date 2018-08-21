package com.pxf.project.common.util.thread;


import com.alibaba.ttl.TransmittableThreadLocal;
import java.util.Map;

public class TransmittableThreadContextUtil extends AbstractThreadContext {
    private static TransmittableThreadLocal<Map<String, Object>> threadContext = new TransmittableThreadLocal();
    private static volatile TransmittableThreadContextUtil app = null;

    private TransmittableThreadContextUtil() {
    }

    public static synchronized TransmittableThreadContextUtil getInstance() {
        if (app == null) {
            Class var0 = TransmittableThreadContextUtil.class;
            synchronized(TransmittableThreadContextUtil.class) {
                if (app == null) {
                    app = new TransmittableThreadContextUtil();
                }
            }
        }

        return app;
    }

    protected ThreadLocal<Map<String, Object>> getThreadContext() {
        return threadContext;
    }
}

