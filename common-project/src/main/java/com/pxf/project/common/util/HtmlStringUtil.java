package com.pxf.project.common.util;

import com.google.common.base.Strings;
import com.pxf.project.common.util.date.DateUtil;
import com.pxf.project.common.util.date.TimeUtil;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 页面展示的封装方法
 * 
 * @author mawei
 * @version $Id: HtmlStringUtil.java, v 0.1 2015年11月12日 下午3:10:45 mawei Exp $
 */
public class HtmlStringUtil {

    private static DecimalFormat decimalFormatter = new DecimalFormat("###,##0.00"); // 小数
    private static DecimalFormat integerFormatter = new DecimalFormat("###,##0");   // 整数
    private static DecimalFormat dataFormatter = new DecimalFormat("#####0.00");   

    /**
     * 号码保密 150***2
     * 
     * @param phone
     * @return 150***0001
     */
    public static String getSecretPhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return "";
        }

        if (phone.length() < 11) {
            return phone;
        }

        return phone.substring(0, 3) + "****" + phone.substring(phone.length() - 4);
    }

    public static Date getDate(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            SimpleDateFormat sf = new SimpleDateFormat(TimeUtil.FORMAT_YMD_LINE);
            return sf.parse(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 姓名隐藏
     * 
     * @param name
     * @return
     */
    public static String getSecretName(String name) {
        if (StringUtils.isEmpty(name)) {
            return "";
        }

        if (name.length() == 1) {
            return "*" + name;
        }

        return "*" + name.substring(1);
    }

    /**
     * 姓名隐藏
     * 
     * @param name
     * @return
     */
    public static String getLastName(String name) {
        if (StringUtils.isEmpty(name)) {
            return "";
        }

        if (name.length() == 1) {
            return "*" + name;
        }

        return "**" + name.substring(name.length() - 1);
    }

    /**
     * 身份证隐藏
     * 
     * @param id
     * @return
     */
    public static String getSecretID(String id) {
        if (StringUtils.isEmpty(id)) {
            return "";
        }

        int length = id.length();

        if (length < 4) {
            return "****" + id;
        }

        return "**************" + id.substring(length - 4);
    }

    /**
     * 金额格式化(###,###.00),小数点后两位向下截取<br>
     * 每三位分割","<br>
     * 123456.01 -> 123,456.01<br>
     * 123456.00 -> 123,456<br>
     * 
     * @param
     * @return
     */
    public static String roundDownFormat(String number) {
        return numberFormat(number, BigDecimal.ROUND_DOWN);
    }
    
    /**
     * 金额格式化(###,###.00),小数点后两位向下截取<br>
     * 无逗号分隔<br>
     * 123456.01 -> 123,456.01<br>
     * 123456.00 -> 123,456<br>
     * 
     * @param
     * @return
     */
    public static String roundDown(BigDecimal number) {
        return dataFormat(number, BigDecimal.ROUND_DOWN);
    }

    /**
     * 金额格式化(###,###.00),小数点后两位向下截取<br>
     * 每三位分割","<br>
     * 123456.01 -> 123,456.01<br>
     * 123456.00 -> 123,456<br>
     * 
     * @param
     * @return
     */
    public static String roundDownFormat(BigDecimal number) {
        return numberFormat(number, BigDecimal.ROUND_DOWN);
    }

    /**
     * 金额格式化(###,###.00),小数点后两位四舍五入<br>
     * 每三位分割","<br>
     * 123456.01 -> 123,456.01<br>
     * 123456.00 -> 123,456<br>
     * 
     * @param
     * @return
     */
    public static String roundUpFormat(String number) {
        return numberFormat(number, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 金额格式化(###,###.00),小数点后两位四舍五入<br>
     * 每三位分割","<br>
     * 123456.01 -> 123,456.01<br>
     * 123456.00 -> 123,456<br>
     * 
     * @param
     * @return
     */
    public static String roundUpFormat(BigDecimal number) {
        return numberFormat(number, BigDecimal.ROUND_HALF_UP);
    }

    //###,###.00
    //若末尾是00，则截取
    public static String formatNumber(BigDecimal number){
        String res = roundUpFormat(number);
        if(!StringUtils.isEmpty(res) && res.endsWith(".00")){
            return res.subSequence(0, res.length() - 3).toString();
        }
        return number.toString();
    }
    
    
    /**
     * 金额格式化(###,###.00)
     * 
     * @param number
     * @param roundType
     *            四舍五入方式 (BigDecimal.**)
     * @return
     */
    public static String numberFormat(String number, int roundType) {
        try {
            BigDecimal numberDecimal = new BigDecimal(number).setScale(2, roundType);
            return decimalFormatter.format(numberDecimal);
        } catch (Exception e) {
            return number;
        }
    }
    
    /**
     * 金额格式化(######.00)
     * 
     * @param number
     * @param roundType 四舍五入方式 (BigDecimal.**)
     * @return
     */
    public static String dataFormat(BigDecimal number, int roundType) {
        try {
            BigDecimal numberDecimal = number.setScale(2, roundType);
            return dataFormatter.format(numberDecimal);
        } catch (Exception e) {
            return "";
        }
    }


    /**
     * 金额格式化(###,###.00)
     * 
     * @param number
     * @param roundType
     *            四舍五入方式 (BigDecimal.**)
     * @return
     */
    public static String numberFormat(BigDecimal number, int roundType) {
        try {
            BigDecimal numberDecimal = number.setScale(2, roundType);
            return decimalFormatter.format(numberDecimal);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 整数格式化(###,##0)
     * 
     * @param number
     * @return
     */
    public static String integerFormat(String number) {
        try {
            BigDecimal numberDecimal = new BigDecimal(number);
            return integerFormatter.format(numberDecimal);
        } catch (Exception e) {
            return number;
        }
    }

    /**
     * 截取给出指定数字的整数部分,并且格式化为"###,##0"
     * 
     * @param number
     * @return
     */
    public static String getNumberInteger(BigDecimal number) {
        if (number == null) {
            return "0";
        }
        try {
            return integerFormatter.format(number.setScale(0, BigDecimal.ROUND_DOWN)).toString();
        } catch (Exception e) {
            return number.toString();
        }
    }
    
    /**
     * 截取整数部分
     * 
     * @param number
     * @return
     */
    public static String getNumberInt(String number) {
        if (number == null) {
            return null;
        }

        String strNumber = number.toString();

        try {
            if (strNumber.indexOf(".") > 0) {
                return strNumber.substring(0,strNumber.indexOf("."));
            }
        } catch (Exception e) {
        }
        return strNumber;
    }
    

    

    /**
     * 截取小数部分
     * 
     * @param number
     * @return
     */
    public static String getNumberDecimal(BigDecimal number) {
        if (number == null) {
            return "00";
        }

        String strNumber = number.toString();

        try {
            if (strNumber.indexOf(".") > 0) {
                return strNumber.substring(strNumber.indexOf(".") + 1);
            }
        } catch (Exception e) {
        }
        return "00";
    }

    /**
     * 获取给定日期的年月日
     * 
     * @param dateString
     * @return
     */
    public static String getDateYMD(String dateString) {
        try {
            return DateUtil.getHyphenDate(TimeUtil.getDate(dateString, TimeUtil.FORMAT_YMDHM_S));
        } catch (Exception e) {
        }
        return dateString;
    }

    /**
     * 将指定的date类型转换为yyyy/MM/dd
     */
    public static String getYMD(Date date) {
        return TimeUtil.getDateString(date, "yyyy/MM/dd");
    }

    /**
     * 将指定的date类型转换为yyyy-MM-dd格式日期
     */
    public static String formatYMDToString(Date date) {
        return TimeUtil.getDateString(date, TimeUtil.FORMAT_YMD_LINE);
    }

    /**
     * 获取时分秒 HH:mm:ss
     * 
     * @param dateString
     * @return
     */
    public static String getDateHMS(String dateString) {
        try {
            return TimeUtil.getTimeHMS(TimeUtil.getDate(dateString, TimeUtil.FORMAT_YMDHMS));
        } catch (Exception e) {
        }
        return dateString;
    }

    /**
     * 获取时分秒 HH:mm:ss
     * 
     * @param
     * @return
     */
    public static String getDateHMS(Date date) {
        try {
            return TimeUtil.getTimeHMS(date);
        } catch (Exception e) {
        }
        return "00:00:00";
    }
    public static String getDateYMDHMS(Date date) {
        try {
            return TimeUtil.getTimeYMDHMS(date);
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 将制定的date类型转换为hhmmss
     */
    public static String getHMS(Date date) {
        return TimeUtil.getDateString(date, TimeUtil.FORMAT_HMS);
    }

    public static String getYMDHMS(Date date) {
        return TimeUtil.getDateString(date, TimeUtil.FORMAT_YMDHM_S);
    }

    /**
     * 截取给定字符串的后N为
     * 
     * @param str
     * @return
     */
    public static String getLastNwords(String str, int length) {
        if (StringUtils.isEmpty(str) || str.length() <= length) {
            return str;
        }

        return str.substring(str.length() - length);
    }

    /**
     * 邮箱隐藏
     * 
     * @param email
     * @return
     */
    public static String getSecretEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return null;
        }

        int indexOf = email.indexOf("@");
        if (indexOf <= 0) {
            return getSecretPhone(email);
        }

        if (indexOf == 1) {
            return email.charAt(0) + "****" + email.substring(indexOf);
        }

        return email.charAt(0) + "****" + email.substring(indexOf - 1);
    }

    public static String getSecretMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return null;
        }

        return mobile.substring(0, 3) + "****" + mobile.substring(mobile.length() - 4);
    }

    /**
     * 获取uuid
     */
    public static String getUUID() {
        return UUIDUtil.getUUID();
    }

    /**
     * 针对公允价，转让单价进行四位小数的保留
     * 
     * @param number
     * @return
     */
    public static String roundUp4Format(String number) {
        try {
            BigDecimal numberDecimal = new BigDecimal(number).setScale(4, BigDecimal.ROUND_HALF_UP);
            return numberDecimal.toString();
        } catch (Exception e) {
            return number;
        }
    }
    
    /**
     * 分割字符串
     * @param src 待处理字符串数据
     * @param regex 根据regex进行分割
     * @param pos 返回字符串下标
     * @return
     */
    public static String splitStr(String src, String regex, int pos) {
    	if(Strings.isNullOrEmpty(src)) {
    		return "";
    	}
    	String[] strs = src.split(regex);
    	if(strs == null || strs.length == 0 || strs.length <= pos) {
    		return "";
    	}
    	return strs[pos];
    }
    

    /**
     * 不区分大小写的比较
     * @param str
     * @param compareStr
     * @return
     */
    public static boolean ignoreCompare(String str,String compareStr) {
    	if(Strings.isNullOrEmpty(str)) {
    		return false;
    	}
    	return str.toUpperCase().equals(compareStr.toUpperCase());
    }
    
    public static void main(String[] args) {
    	System.out.println(splitStr("0rr","-",1));
    }
}
