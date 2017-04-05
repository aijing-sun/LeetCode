package org.sunjane.array;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int res = 0;
        for (int a : A) {
            for (int b : B) {
                sum = a + b;
                if (map.containsKey(sum)) {
                	map.put(sum, map.get(sum) + 1);
                } else {
                	map.put(sum, 1);
                }
            }
        }
        
        for (int c : C) {
        	for (int d : D) {
        		sum = - (c + d);
        		if (map.containsKey(sum)) {
        			res += map.get(sum);
        		}
        	}
        }
        return res;
    }
}
