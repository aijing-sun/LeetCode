package org.sunjane.string;

public class CompareVersion {
    public static int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) return 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        int a, b;
        while (i < v1.length && i < v2.length) {
        	a = Integer.parseInt(v1[i]);
        	b = Integer.parseInt(v2[i]);
        	if (a > b) 
        		return 1;
        	else if (a < b) 
        		return -1;
        	i++;
        }
        if (i < v1.length) {
            if (isRemainZero(v1, i))
        	    return 0;
        	else
        	    return 1;
        }
        else if (i < v2.length) {
            if (isRemainZero(v2, i)) 
                return 0;
            else 
        	    return -1;
        }
        else 
            return 0;
        
    
    }
    
    private static boolean isRemainZero(String[] v, int index) {
        int sum = 0;
        for (int i = index; i < v.length; i++) {
            sum += Integer.parseInt(v[i]);
            if (sum > 0)
                return false;
        }
        return true;
    }
}
