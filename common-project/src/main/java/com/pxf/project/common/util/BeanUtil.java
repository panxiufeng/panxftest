package com.pxf.project.common.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.springframework.util.ReflectionUtils.FieldFilter;
import org.springframework.util.ReflectionUtils.MethodCallback;
import org.springframework.util.ReflectionUtils.MethodFilter;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.DataBinder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BeanUtil {

    public BeanUtil() {
    }

    public static BeanUtil.SYPropertyEditor getSYPropertyEditor(Class<?> clazz, String name, PropertyEditor pe) {
        return new BeanUtil.SYPropertyEditor(clazz, name, pe);
    }

    public static <T> T map2bean(Class<T> clazz, Map<String, Object> map, BeanUtil.SYPropertyEditor... sype) {
        T target = BeanUtils.instantiateClass(clazz);
        DataBinder db = new DataBinder(target);
        if (sype != null) {
            BeanUtil.SYPropertyEditor[] var5 = sype;
            int var6 = sype.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                BeanUtil.SYPropertyEditor sy = var5[var7];
                db.registerCustomEditor(sy.getClazz(), sy.getName(), sy.getPe());
            }
        }

        MutablePropertyValues mv = new MutablePropertyValues(map);
        db.bind(mv);
        return target;
    }

    public static Map<String, Object> bean2map(Object bean, String... ingore) {
        List<String> ilist = ingore == null ? new ArrayList() : Arrays.asList(ingore);
        Map<String, Object> map = new HashMap();
        BeanWrapperImpl bi = new BeanWrapperImpl(bean);
        PropertyDescriptor[] pds = bi.getPropertyDescriptors();
        PropertyDescriptor[] var6 = pds;
        int var7 = pds.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            PropertyDescriptor pd = var6[var8];
            String name = pd.getName();
            if (((List)ilist).indexOf(name) == -1 && !name.equals("class")) {
                Object value = bi.getPropertyValue(name);
                map.put(name, value);
            }
        }

        return map;
    }

    public static List<Map<String, Object>> listBean2listMap(List<?> beans, String... ingore) {
        List<Map<String, Object>> ret = new ArrayList();
        Iterator var3 = beans.iterator();

        while(var3.hasNext()) {
            Object bean = var3.next();
            ret.add(bean2map(bean, ingore));
        }

        return ret;
    }

    public static Object getField(Field field, Object target) {
        ReflectionUtils.makeAccessible(field);
        return ReflectionUtils.getField(field, target);
    }

    public static Object getField(String fieldName, Object target) {
        Field field = findField(target.getClass(), fieldName);
        return field != null ? getField(field, target) : null;
    }

    public static Field findField(Class<?> clazz, String fieldName) {
        return ReflectionUtils.findField(clazz, fieldName);
    }

    public static void setField(Field field, Object target, Object value) {
        ReflectionUtils.makeAccessible(field);
        ReflectionUtils.setField(field, target, value);
    }

    public static void setField(String fieldName, Object target, Object value) {
        Field field = findField(target.getClass(), fieldName);
        if (null != field) {
            setField(field, target, value);
        }

    }

    public static void setStaticField(String fieldName, Class<?> clazz, Object value) {
        Field field = findField(clazz, fieldName);
        if (null != field) {
            setField((Field)field, clazz, value);
        }

    }

    public static <A extends Annotation> List<Field> getFieldsByAnnotaion(Class<?> clazz, final Class<A> annotationType) {
        final List<Field> list = new ArrayList();
        ReflectionUtils.doWithFields(clazz, new FieldCallback() {
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                list.add(field);
            }
        }, new FieldFilter() {
            public boolean matches(Field field) {
                return null != field.getAnnotation(annotationType);
            }
        });
        return list;
    }

    public static <A extends Annotation> List<Method> getMethodsByAnnotation(Class<?> clazz, final Class<A> annotationType) {
        final List<Method> list = new ArrayList();
        ReflectionUtils.doWithMethods(clazz, new MethodCallback() {
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                list.add(method);
            }
        }, new MethodFilter() {
            public boolean matches(Method method) {
                return null != AnnotationUtils.findAnnotation(method, annotationType);
            }
        });
        return list;
    }

    public static void bean2xml(Object bean, OutputStream out, Map<String, Object> config) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(bean.getClass());
        Marshaller mar = context.createMarshaller();
        if (null != config) {
            Iterator var5 = config.entrySet().iterator();

            while(var5.hasNext()) {
                Map.Entry<String, Object> entity = (Map.Entry)var5.next();
                mar.setProperty((String)entity.getKey(), entity.getValue());
            }
        }

        mar.marshal(bean, out);
    }

    public static void bean2xml(Object bean, Writer w, Map<String, Object> config) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(bean.getClass());
        Marshaller mar = context.createMarshaller();
        if (null != config) {
            Iterator var5 = config.entrySet().iterator();

            while(var5.hasNext()) {
                Map.Entry<String, Object> entity = (Map.Entry)var5.next();
                mar.setProperty((String)entity.getKey(), entity.getValue());
            }
        }

        mar.marshal(bean, w);
    }

    public static <T> T xml2bean(Class<T> clazz, InputStream in) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller umar = context.createUnmarshaller();
        return (T)umar.unmarshal(in);
    }

    public static <T> T xml2bean(Class<T> clazz, Reader reader) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller umar = context.createUnmarshaller();
        return (T)umar.unmarshal(reader);
    }

    public static void copyCollection(Collection source, Collection target, boolean append) {
        Assert.notNull(source);
        Assert.notNull(target);
        if (!append) {
            target.clear();
        }

        Iterator iter = source.iterator();

        while(iter.hasNext()) {
            target.add(iter.next());
        }

    }

    public static void copyProperties(Object source, Object target) {
        copyProperties(source, target, (Class)null, (String[])null);
    }

    public static void copyProperties(Object source, Object target, Class<?> editable, String[] ignoreProperties) throws BeansException {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Class<?> actualEditable = target.getClass();
        if (editable != null) {
            if (!editable.isInstance(target)) {
                throw new IllegalArgumentException("Target class [" + target.getClass().getName() + "] not assignable to Editable class [" + editable.getName() + "]");
            }

            actualEditable = editable;
        }

        PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);
        List<String> ignoreList = ignoreProperties != null ? Arrays.asList(ignoreProperties) : null;
        PropertyDescriptor[] var7 = targetPds;
        int var8 = targetPds.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            PropertyDescriptor targetPd = var7[var9];
            if (targetPd.getWriteMethod() != null && (ignoreProperties == null || !ignoreList.contains(targetPd.getName()))) {
                PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null && sourcePd.getReadMethod() != null) {
                    try {
                        Method readMethod = sourcePd.getReadMethod();
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }

                        Object value = readMethod.invoke(source);
                        Method writeMethod = targetPd.getWriteMethod();
                        if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                            writeMethod.setAccessible(true);
                        }

                        if (value instanceof Collection) {
                            Method targetReadMethod = targetPd.getReadMethod();
                            Object targetValue = targetReadMethod.invoke(target);
                            if (null != targetValue) {
                                copyCollection((Collection)value, (Collection)targetValue, false);
                                continue;
                            }
                        }

                        writeMethod.invoke(target, value);
                    } catch (Throwable var17) {
                        throw new FatalBeanException("Could not copy properties from source to target", var17);
                    }
                }
            }
        }

    }

    private static class SYPropertyEditor {
        private Class<?> clazz;
        private String name;
        private PropertyEditor pe;

        private SYPropertyEditor(Class<?> clazz, String name, PropertyEditor pe) {
            this.clazz = clazz;
            this.name = name;
            this.pe = pe;
        }

        private SYPropertyEditor() {
        }

        public Class<?> getClazz() {
            return this.clazz;
        }

        public void setClazz(Class<?> clazz) {
            this.clazz = clazz;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public PropertyEditor getPe() {
            return this.pe;
        }

        public void setPe(PropertyEditor pe) {
            this.pe = pe;
        }
    }
}
