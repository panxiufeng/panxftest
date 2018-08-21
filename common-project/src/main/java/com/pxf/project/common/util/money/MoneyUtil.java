package com.pxf.project.common.util.money;


import com.pxf.project.common.util.CashMapSortUtil;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MoneyUtil {
    public MoneyUtil() {
    }

    public static BigDecimal toNull(BigDecimal mny) {
        return mny == null ? new BigDecimal("0") : new BigDecimal(mny.setScale(4, 4).toString());
    }

    public static boolean compare(BigDecimal mny1, BigDecimal mny2) {
        return toNull(mny1).setScale(4, 1).compareTo(toNull(mny2).setScale(4, 1)) == 0;
    }

    public static boolean isZero(BigDecimal mny) {
        return toNull(mny).equals(BigDecimal.valueOf(0L).setScale(4, 4));
    }

    public static boolean notLessThan(BigDecimal mny1, BigDecimal mny2) {
        return toNull(mny1).compareTo(toNull(mny2)) >= 0;
    }

    public static BigDecimal add(BigDecimal mny1, BigDecimal mny2) {
        return toNull(mny1).add(toNull(mny2));
    }

    public static BigDecimal subtract(BigDecimal mny1, BigDecimal mny2) {
        return toNull(mny1).subtract(toNull(mny2));
    }

    public static BigDecimal multiply(BigDecimal mny1, BigDecimal mny2) {
        return toNull(mny1).multiply(toNull(mny2));
    }

    public static BigDecimal divide(BigDecimal mny1, BigDecimal mny2) {
        return toNull(mny1).divide(toNull(mny2), 4, 4);
    }

    public static BigDecimal format(BigDecimal mny) {
        return toNull(mny).setScale(2, 4);
    }

    public static Map<String, BigDecimal> sum(TreeMap<String, BigDecimal> mny1, BigDecimal mny2) {
        CashMapSortUtil sort = new CashMapSortUtil();
        sort.sortMapByValue(mny1);
        Map<String, BigDecimal> returnMap = sort.getSortReturnInfo();
        if (notLessThan(sort.getSumMoney(), mny2.setScale(2, 1))) {
            throw new RuntimeException("兑付金额大于还款金额");
        } else {
            int sum = multiply(subtract(mny2, sort.getSumMoney()).setScale(2, 1), new BigDecimal(100)).setScale(0, 1).intValue();
            Iterator<String> iters = returnMap.keySet().iterator();

            for(int i = 0; i < sum; ++i) {
                String key = (String)iters.next();
                BigDecimal amt = add((BigDecimal)returnMap.get(key), (new BigDecimal("0.01")).setScale(2, 1));
                returnMap.put(key, amt);
            }

            return returnMap;
        }
    }
}
