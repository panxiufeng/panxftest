package com.pxf.project.common.util.page;


import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtils {
    public PageUtils() {
    }

    public static <T> Map<String, Object> setPageList(List<T> partnerInfoBeans, int start, int pageSize) {
        HashMap map;
        if (CollectionUtils.isEmpty(partnerInfoBeans)) {
            map = new HashMap();
            map.put("totalCount", Integer.valueOf(0));
            map.put("list", Collections.emptyList());
            return map;
        } else {
            map = new HashMap();
            List<T> currentPageList = new ArrayList();
            int length = getPageEndSize(start + pageSize, partnerInfoBeans.size());
            if (start != -1 && pageSize != -1) {
                for(int i = start; i < length; ++i) {
                    ((List)currentPageList).add(partnerInfoBeans.get(i));
                }
            } else {
                currentPageList = partnerInfoBeans;
            }

            map.put("list", currentPageList);
            map.put("totalCount", partnerInfoBeans.size());
            return map;
        }
    }

    public static <T> PaginationSupport<T> setPaginationObject(List<T> partnerInfoBeans, int start, int pageSize) {
        Map<String, Object> map = setPageList(partnerInfoBeans, start, pageSize);
        int totalCount = ((Integer)map.get("totalCount")).intValue();
        List<T> currentPageList = (List)map.get("list");
        return new PaginationSupport(currentPageList, totalCount, start);
    }

    private static int getPageEndSize(int count, int size) {
        return count < size ? count : size;
    }
}