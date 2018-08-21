package com.pxf.project.common.util;


import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Comparator;
import java.util.Map.Entry;

public class MapValueComparatorUtil implements Comparator<Entry<String, BigDecimal>> {
    public static String ASC = "ASC";
    public static String DESC = "DESC";
    private String sortType;

    public MapValueComparatorUtil(String sortType) {
        this.sortType = sortType;
    }

    public int compare(Entry<String, BigDecimal> me1, Entry<String, BigDecimal> me2) {
        String mny1 = ((BigDecimal)me1.getValue()).round(MathContext.DECIMAL64).setScale(3, 1).toString();
        String mny2 = ((BigDecimal)me2.getValue()).round(MathContext.DECIMAL64).setScale(3, 1).toString();
        int returnInt;
        if (this.sortType.equals(DESC)) {
            returnInt = mny2.substring(mny2.indexOf(".") + 3).compareTo(mny1.substring(mny1.indexOf(".") + 3));
        } else {
            returnInt = mny1.substring(mny1.indexOf(".") + 3).compareTo(mny2.substring(mny2.indexOf(".") + 3));
        }

        return returnInt == 0 ? ((String)me1.getKey()).compareTo((String)me2.getKey()) : returnInt;
    }
}
