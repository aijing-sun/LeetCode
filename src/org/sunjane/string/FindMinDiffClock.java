package org.sunjane.string;

import java.util.ArrayList;
import java.util.List;

public class FindMinDiffClock {

	public static void main1(String[] args) {
		// TODO Auto-generated method stub

		List<String> times = new ArrayList<String>();
		times.add("23:59");
		times.add("00:00");
		System.out.println(findMinDifference(times));
	}
	public static int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int[] arr = new int[len];
        String[] str = new String[2];
        int mod = 24 * 60;
        for (int i = 0; i < len; i++) {
            str = timePoints.get(i).split(":");
            arr[i] = Integer.parseInt(str[0]) * 60;
            arr[i] += Integer.parseInt(str[1]);
        }
        int min = Integer.MAX_VALUE;
        int abs;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                abs = Math.abs(arr[i] - arr[j]);
                min = Math.min(mod - abs, min);
                min = Math.min(abs, min);
            }
        }
        return min;
        
    }

}
