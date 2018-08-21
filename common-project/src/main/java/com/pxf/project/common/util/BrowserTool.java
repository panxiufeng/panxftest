package com.pxf.project.common.util;

import org.apache.commons.lang.StringUtils;

public class BrowserTool {
	
	public final static String CHROME = "Chrome";
	
	public static boolean isChrome(String userAgent) {
		if (StringUtils.isEmpty (userAgent)) {
			return false;
		}

		if (userAgent.toLowerCase ().indexOf (CHROME.toLowerCase ()) > 0) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {

	}

}
