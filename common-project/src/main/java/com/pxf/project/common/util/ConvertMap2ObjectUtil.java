package com.pxf.project.common.util;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConvertMap2ObjectUtil<V> {
    public ConvertMap2ObjectUtil() {
    }

    public static <V> V map2Object(Map<String, Object> map, V v) throws IllegalAccessException {
        Class<?> clazz = v.getClass();
        List<Field> list = Lists.newArrayList(clazz.getDeclaredFields());
        Iterator var4 = list.iterator();

        while(var4.hasNext()) {
            Field field = (Field)var4.next();
            int mod = field.getModifiers();
            if (!Modifier.isStatic(mod) && !Modifier.isFinal(mod)) {
                field.setAccessible(true);
                field.set(v, map.get(field.getName()));
            }
        }

        return v;
    }

    public static <V> Map<String, Object> object2Map(V v) throws IllegalAccessException {
        Map<String, Object> map = Maps.newHashMap();
        Class<?> clazz = v.getClass();
        List<Field> list = Lists.newArrayList(clazz.getDeclaredFields());
        Iterator var4 = list.iterator();

        while(var4.hasNext()) {
            Field field = (Field)var4.next();
            int mod = field.getModifiers();
            if (!Modifier.isStatic(mod) && !Modifier.isFinal(mod)) {
                field.setAccessible(true);
                Object object = field.get(v);
                map.put(field.getName(), object);
            }
        }

        return map;
    }
}
