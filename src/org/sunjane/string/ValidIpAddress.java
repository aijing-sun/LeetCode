package org.sunjane.string;

import java.util.Arrays;

public class ValidIpAddress {
	public static String validIPAddress(String IP) {
		
		String[] arr;
        if (IP.contains(".")) {
        	arr = IP.split("\\."); // dot is a special char for regex
//        	System.out.println(IP.split("\\.").length);
//        	System.out.println(IP);
        	if (arr.length != 4) return "Neither";
        	int temp;
        	for (String val : arr) {
        		if (val.startsWith("0") && val.length() > 1) {
        			return "Neither";
        		}
        		if (!val.matches("\\d*")) return "Neither";
        		temp = Integer.parseInt(val);
        		if (temp < 0 || temp > 255) return "Neither";
        	}
        	return "IPv4";
        } else if (IP.contains(":")) {
        	arr = IP.split(":");
        	if (arr.length != 8) return "Neither";
        	
        	for (String val : arr) {
        		if (val.length() > 4) return "Neither";
        		if (!val.toLowerCase().matches("([a-f]|([0-9])){1,4}")) 
        			return "Neither";
        		
        	}
        	return "IPv6";
        }
        
        return "Neither";
    }
}
