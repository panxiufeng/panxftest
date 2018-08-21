package com.pxf.project.common.util.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 判断string是否为数字
 * */
public class IsNumber {
	public boolean isNumber(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		}
}
