package com.pxf.project.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BeanCopy {

    /**
     * 创建目标Bean,并复制fromObj的属性值至
     * @param fromObj 
     * @param newObjClass 目标类
     * @return
     */
    public static <T> T copy(Object fromObj, Class<T> newObjClass) {
        T newT = null;
        try {
            newT = newObjClass.newInstance();
            if (fromObj == null) {
                return newT;
            }

            //获取fromBean的属性值
            Field[] fields = getFiled(fromObj.getClass(), fromObj.getClass().getDeclaredFields());
            if (fields == null || fields.length == 0) {
                return newT;
            }
            Map<String, Object> map = new HashMap<String, Object>();
            for (Field field : fields) {
                field.setAccessible(true);
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                Object obj = field.get(fromObj);
                if (obj == null) {
                    continue;
                }
                setFieldValue(field, obj, map);
            }

            Method[] methods = newObjClass.getMethods();
            if (methods == null || methods.length == 0) {
                return newT;
            }
            for (Method method : methods) {
                String methodName = method.getName();
                if (methodName.length() < 4) {
                    continue;
                }

                if (Modifier.isStatic(method.getModifiers())) {
                    continue;
                }

                // support builder set
                //                if (!(method.getReturnType().equals(Void.TYPE) || isBuilderModel(method,
                //                    newObjClass.getCanonicalName()))) {
                //                    continue;
                //                }

                if (method.getParameterTypes().length != 1) {
                    continue;
                }

                if (!methodName.startsWith("set")) {
                    continue;
                }

                String propertyName = Character.toLowerCase(methodName.charAt(3))
                                      + methodName.substring(4);
                setValue(method, newT, map, propertyName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return newT;
    }

    private static void setFieldValue(Field field, Object obj, Map<String, Object> map) {
        //如果是Boolean
        String name = field.getName();
        if (field.getType() == boolean.class && name.length() > 2) {
            if (name.startsWith("is")) {
                String name_without_is = name.substring(2);
                String name_wihtout_is_lower = Character.toLowerCase(name_without_is.charAt(0))
                                               + name_without_is.substring(1);
                map.put(name_without_is, obj);
                map.put(name_wihtout_is_lower, obj);
            }
        }
        map.put(name, obj);
    }

    //    private static boolean isBuilderModel(Method method, String objClazz) {
    //        String methodClazz = method.getReturnType().getCanonicalName();
    //        if (methodClazz != null) {
    //            return methodClazz.equals(objClazz);
    //        }
    //        return false;
    //    }

    private static void setValue(Method method, Object newObj, Map<String, Object> values,
                                 String propertyName) {
        try {
            method.invoke(newObj, values.get(propertyName));
        } catch (Exception e) {
            e.printStackTrace();
            //do nothing
        }
    }

    /**
     * 递归获取class及其父类
     */
    private static Field[] getFiled(Class<?> clazz, Field[] fileds) {
        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz == null) {
            return fileds;
        }

        Field[] superFileds = superClazz.getDeclaredFields();
        if (superFileds == null || superFileds.length <= 0) {
            return fileds;
        }
        Field[] newFileds = Arrays.copyOf(fileds, fileds.length + superFileds.length);
        int arrIndex = fileds.length;
        for (Field filed : superFileds) {
            newFileds[arrIndex] = filed;
            arrIndex++;
        }
        return newFileds;
    }

}
