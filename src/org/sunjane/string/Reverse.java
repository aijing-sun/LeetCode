package org.sunjane.string;

public class Reverse {
	 public static int reverse(int x) {
	        char[] res = String.valueOf(x).toCharArray();
	        int i;
	        int len = res.length;
	        if (res[0] == '-') {
	            i = 1;
	        } else {
	            i = 0;
	        }
	        int start = i;
	        int end = len - 1;
	        char temp;
	        while (start < end) {
	            temp = res[start];
	            res[start++] = res[end];
	            res[end--] = temp;
	        }
	        long fin = Long.parseLong(new String(res));
	        fin = fin > Integer.MAX_VALUE ? 0 : fin;
	        fin = fin < Integer.MIN_VALUE ? 0 : fin;
	        return (int)fin;
	        
	    }

}
