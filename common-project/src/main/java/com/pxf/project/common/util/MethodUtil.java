package com.pxf.project.common.util;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class MethodUtil {
    public MethodUtil() {
    }

    public static Method getTargetMethod(Class<?> clazz, Object[] pararm, String methodName) {
        List<Method> mList = new ArrayList();
        Method[] methods = clazz.getMethods();
        Method[] var5 = methods;
        int var6 = methods.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Method method = var5[var7];
            if (method.getName().equals(methodName)) {
                mList.add(method);
            }
        }

        if (mList.size() == 0) {
            return null;
        } else if (mList.size() == 1) {
            return (Method)mList.get(0);
        } else {
            Method result = null;
            Iterator var14 = mList.iterator();

            while(true) {
                if (var14.hasNext()) {
                    Method m = (Method)var14.next();
                    Class<?>[] classes = m.getParameterTypes();
                    if (classes.length == 0 && (pararm == null || pararm.length == 0)) {
                        return m;
                    }

                    if (pararm == null || pararm.length == 0) {
                        return null;
                    }

                    if (classes.length != pararm.length) {
                        continue;
                    }

                    boolean flag = true;

                    for(int i = 0; i < classes.length; ++i) {
                        Class<?> clzss = classes[i];
                        Class<?> paramClzss = pararm[i].getClass();
                        if (!clzss.toString().equals(paramClzss.toString())) {
                            flag = false;
                            break;
                        }
                    }

                    if (!flag) {
                        continue;
                    }

                    result = m;
                }

                return result;
            }
        }
    }

    public static String getClassMethodKey(Class<?> clazz, Object[] pararm, String methodName) {
        StringBuilder sb = new StringBuilder();
        sb.append(clazz.toString());
        sb.append(".").append(methodName);
        if (pararm != null && pararm.length > 0) {
            Object[] var4 = pararm;
            int var5 = pararm.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                Object obj = var4[var6];
                sb.append("-").append(obj.getClass().toString());
            }
        }

        return sb.toString();
    }
}