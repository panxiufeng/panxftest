package com.pxf.project.common.util;


import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class CashMapSortUtil {
    private Map<String, BigDecimal> sortReturnInfo = new LinkedHashMap();
    private BigDecimal sumMoney = new BigDecimal(0);

    public CashMapSortUtil() {
    }

    public void sortMapByValue(TreeMap<String, BigDecimal> sortRequestInfo) {
        if (sortRequestInfo != null && !sortRequestInfo.isEmpty()) {
            List<Entry<String, BigDecimal>> entryList = new ArrayList(sortRequestInfo.entrySet());
            Collections.sort(entryList, new MapValueComparatorUtil(MapValueComparatorUtil.DESC));
            Iterator<Entry<String, BigDecimal>> iter = entryList.iterator();
            Entry tmpEntry = null;

            while(iter.hasNext()) {
                tmpEntry = (Entry)iter.next();
                this.sumMoney = ((BigDecimal)tmpEntry.getValue()).round(MathContext.DECIMAL64).setScale(2, 1).add(this.sumMoney.round(MathContext.DECIMAL64).setScale(2, 1));
                this.sortReturnInfo.put((String)tmpEntry.getKey(), (BigDecimal)tmpEntry.getValue());
            }

        }
    }

    public Map<String, BigDecimal> getSortReturnInfo() {
        return this.sortReturnInfo;
    }

    public BigDecimal getSumMoney() {
        return this.sumMoney;
    }
}
