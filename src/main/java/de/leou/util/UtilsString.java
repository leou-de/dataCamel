package de.leou.util;

public class UtilsString {
	static public String delSuffix(String orgString,String suffix) {
		if (orgString ==null) return "";
		if (orgString.trim().equals("")) return "";
		while (orgString.endsWith(suffix)) {
			orgString= orgString.substring(0,orgString.lastIndexOf(suffix)).trim();
		}
		
		return orgString;

	}

}
