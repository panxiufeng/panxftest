package com.pxf.project.common.util;

import com.google.common.base.Objects;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pxf.project.common.annotation.UnExpose;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GsonUtil {
    private static final Gson gson = (new GsonBuilder()).enableComplexMapKeySerialization().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    private static final Gson gson2 = (new GsonBuilder()).enableComplexMapKeySerialization().serializeNulls().setExclusionStrategies(new ExclusionStrategy[]{new ExclusionStrategy() {
        public boolean shouldSkipField(FieldAttributes f) {
            return null != f.getAnnotation(UnExpose.class);
        }

        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    }}).setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private GsonUtil() {
    }

    public static String objToStrForLog(Object object) {
        return Objects.equal((Object) null, object) ? null : gson2.toJson(object);
    }

    public static String objectToJsonString(Object object) {
        if (Objects.equal((Object) null, object)) {
            return null;
        } else {
            String jsonString = gson.toJson(object);
            return jsonString;
        }
    }

    public static <T> T jsonStringToObject(String jsonStr, Class<T> type) {
        T result = gson.fromJson(jsonStr, type);
        return result;
    }

    public static <T> List<T> jsonToList(String str, Class<T> tClass) {
        List<T> list = new ArrayList();
        JsonArray array = (new JsonParser()).parse(str).getAsJsonArray();
        Iterator var4 = array.iterator();

        while (var4.hasNext()) {
            JsonElement elem = (JsonElement) var4.next();
            list.add((new Gson()).fromJson(elem, tClass));
        }

        return list;
    }

    public static <T> T jsonStringToObject(String jsonStr, Type typeOfT) {
        try {
            T result = gson.fromJson(jsonStr, typeOfT);
            return result;
        } catch (Exception var3) {
            return null;
        }
    }

    public static String getStringByKey(String jsonStr, String key) {
        JsonObject jo = (new JsonParser()).parse(jsonStr).getAsJsonObject();
        JsonElement je = jo.get(key);
        return Objects.equal((Object) null, je) ? null : je.getAsString();
    }

    public static String getStringByKeyFore(String jsonStr, String key) {
        String reStr = null;
        JsonObject jo = null;
        if (StringUtil.isBlank(jsonStr)) {
            return null;
        } else {
            try {
                jo = (new JsonParser()).parse(jsonStr).getAsJsonObject();
            } catch (Exception var11) {
                return null;
            }

            JsonElement je1 = jo.get(key);
            if (!Objects.equal((Object) null, je1)) {
                try {
                    return je1.getAsString();
                } catch (Exception var10) {
                    return gson.toJson(je1);
                }
            } else {
                Set<Entry<String, JsonElement>> set = jo.entrySet();
                Iterator var6 = set.iterator();

                while (var6.hasNext()) {
                    Entry<String, JsonElement> entry = (Entry) var6.next();
                    JsonElement je = (JsonElement) entry.getValue();
                    String str = gson.toJson(je);
                    reStr = getStringByKeyFore(str, key);
                    if (StringUtil.isNotBlank(reStr)) {
                        break;
                    }
                }

                return reStr;
            }
        }
    }

    public static String toMetadataJson(String jsonStr) {
        JsonObject jo = null;

        try {
            jo = (new JsonParser()).parse(jsonStr).getAsJsonObject();
        } catch (Exception var10) {
            return null;
        }

        Set<Entry<String, JsonElement>> set = jo.entrySet();
        Entry entry;
        if (!set.isEmpty()) {
            for (Iterator var3 = set.iterator(); var3.hasNext(); jsonStr = toMetadataJson(entry, jsonStr)) {
                entry = (Entry) var3.next();
                JsonElement je = (JsonElement) entry.getValue();
                String str = gson.toJson(je);
                String oldStr = str;

                try {
                    (new JsonParser()).parse(str).getAsJsonObject();
                    str = toMetadataJson(str);
                    jsonStr = jsonStr.replace(oldStr, str);
                } catch (Exception var9) {
                    ;
                }
            }
        }

        return jsonStr;
    }

    private static String toMetadataJson(Entry<String, JsonElement> entry, String jsonStr) {
        String key = (String) entry.getKey();
        Pattern pattern = Pattern.compile("[A-Z]");

        String oldStr;
        String newStr;
        for (Matcher matcher = pattern.matcher(key); matcher.find(); key = key.replace(oldStr, newStr)) {
            oldStr = matcher.group();
            newStr = "_" + oldStr.toLowerCase();
        }

        return jsonStr.replace(key, key);
    }

    public static String toObjectJson(String jsonStr) {
        JsonObject jo = null;

        try {
            jo = (new JsonParser()).parse(jsonStr).getAsJsonObject();
        } catch (Exception var10) {
            return null;
        }

        Set<Entry<String, JsonElement>> set = jo.entrySet();
        Entry entry;
        if (!set.isEmpty()) {
            for (Iterator var3 = set.iterator(); var3.hasNext(); jsonStr = toObjectJson(entry, jsonStr)) {
                entry = (Entry) var3.next();
                JsonElement je = (JsonElement) entry.getValue();
                String str = gson.toJson(je);
                String oldStr = str;

                try {
                    (new JsonParser()).parse(str).getAsJsonObject();
                    str = toObjectJson(str);
                    jsonStr = jsonStr.replace(oldStr, str);
                } catch (Exception var9) {
                    ;
                }
            }
        }

        return jsonStr;
    }

    private static String toObjectJson(Entry<String, JsonElement> entry, String jsonStr) {
        String key = (String) entry.getKey();
        Pattern pattern = Pattern.compile("_[a-z]");

        String oldStr;
        String newStr;
        for (Matcher matcher = pattern.matcher(key); matcher.find(); key = key.replace(oldStr, newStr)) {
            oldStr = matcher.group();
            newStr = oldStr.toUpperCase().split("_")[1];
        }

        return jsonStr.replace(key, key);
    }

    public static String replaceJsonValue(String jsonStr, String key, Object value) {
        JsonObject jo = null;

        try {
            jo = (new JsonParser()).parse(jsonStr).getAsJsonObject();
        } catch (Exception var10) {
            return (String) gson.fromJson(jo, String.class);
        }

        JsonElement je1 = jo.get(key);
        if (!Objects.equal((Object) null, je1)) {
            jo.remove(key);
            JsonElement je = (JsonElement) gson.fromJson(gson.toJson(value), JsonElement.class);
            jo.add(key, je);
            return gson.toJson(jo);
        } else {
            Set<Entry<String, JsonElement>> set = jo.entrySet();
            Iterator var6 = set.iterator();

            while (var6.hasNext()) {
                Entry<String, JsonElement> entry = (Entry) var6.next();
                JsonElement curEntry = (JsonElement) entry.getValue();
                String str = gson.toJson(curEntry);
                str = replaceJsonValue(str, key, value);
                jo.remove((String) entry.getKey());
                jo.add((String) entry.getKey(), (JsonElement) gson.fromJson(str, JsonElement.class));
            }

            return gson.toJson(jo);
        }
    }

}