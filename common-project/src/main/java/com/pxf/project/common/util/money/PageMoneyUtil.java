package com.pxf.project.common.util.money;


import java.math.BigDecimal;

public class PageMoneyUtil {
    public PageMoneyUtil() {
    }

    public static BigDecimal add(BigDecimal mny1, BigDecimal mny2) {
        return MoneyUtil.toNull(mny1).add(MoneyUtil.toNull(mny2)).setScale(2, 4);
    }

    public static BigDecimal subtract(BigDecimal mny1, BigDecimal mny2) {
        return MoneyUtil.toNull(mny1).subtract(MoneyUtil.toNull(mny2)).setScale(2, 4);
    }

    public static BigDecimal multiply(BigDecimal mny1, BigDecimal mny2) {
        return MoneyUtil.toNull(mny1).multiply(MoneyUtil.toNull(mny2)).setScale(2, 4);
    }

    public static BigDecimal divide(BigDecimal mny1, BigDecimal mny2) {
        return MoneyUtil.toNull(mny1).divide(MoneyUtil.toNull(mny2)).setScale(2, 4);
    }
}
