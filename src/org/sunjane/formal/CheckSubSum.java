package org.sunjane.formal;

import java.util.HashMap;
import java.util.Map;

public class CheckSubSum {
	
	// refer to https://leetcode.com/problems/continuous-subarray-sum/#/solutions
	// make good use with congruence modulo
	public static boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		if (nums.length == 0) return false;
		int sum = 0; // restore the continuous sum mod k
		// so sum = sum(i) % k; 
		// sumi = sumj only when [sum(i) - sum(j)] % k == 0
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k != 0) sum %= k;
			if (map.containsKey(sum)) {
				if (i - map.get(sum) > 1) // at least two number
					return true;
			} else {
				map.put(sum, i);
			}
		}
		return false;
	}
	
	// time limited
	public static boolean checkSubarraySum1(int[] nums, int k) {
		if (nums.length == 0)
			return false;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1] && nums[i] == 0)
				return true;
		}
		if (k == 0) return false;
		return subCheckSum(nums, 0, 0, k);
	}

	private static boolean subCheckSum(int[] nums, int index, int sum, int k) {
		if (index == nums.length)
			return false;
		sum = sum + nums[index];
		// make sure sum is not zero
		if (sum % k == 0 && sum != nums[index])
			return true;

		// add nums[index]
		if (subCheckSum(nums, index + 1, sum, k))
			return true;
		// without nums[index], so reset sum to zero
		if (subCheckSum(nums, index + 1, 0, k))
			return true;

		return false;
	}
}
