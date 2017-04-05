package org.sunjane.array;

public class SplitArray {
	
	
	// use dynamic programming
    public static int splitArray(int[] nums, int m) {
    	
    	int[] sum = sumArr(nums);
    	
        if (m == 1) return sum[sum.length - 1];
        
        // dp[s][j] means the largest sum when dividing 
        // the first j + 1 elements into s non-empty blocks 
        int[] dp = new int[sum.length];
        
        // first consider s = 1, so the sum of sub array is 
        // the largest sum
        for (int i = 0; i < sum.length; i++) {
        	dp[i] = sum[i];
        }
        
        // s start from 2 to m
        for (int s = 2; s <= m; s++) {
        	// j start from len - 1 to s - 1
        	// dp[s][j] = Min{max(dp[s - 1][i], 
        	//				n[j] + n[j - 1] + ... + n[i + 1])} (s - 2 <= i < j)
        	for (int j = sum.length - 1; j >= s - 1; j--) {
        		
        		dp[j] = Integer.MAX_VALUE;
        		for (int i = s - 2; i < j; i++) {
        			dp[j] = Math.min(dp[j], Math.max(dp[i], sum[j] - sum[i]));
        		}
        		
        	}
        }
        return dp[sum.length - 1];
        
        
    }
    
//    private static int subMaxSum(int[] nums, int index, int m, int avg) {
//    	int sum = 0;
//    	for (int i = index; i < nums.length - m; i++) {
//    		sum += nums[index];
//    		if (sum == avg) {
//    			subMaxSum(nums, index + 1, m - 1, avg);
//    		} else if (sum > avg) {
//    			subMaxSum(nums, index + 1, m - 1, avg);
//    		}
//    	}
//    }
    
    private static int[] sumArr(int[] nums) {
    	int[] sum = new int[nums.length];
    	int temp = 0;
    	int count = 0;
    	for (int val : nums) {
    		temp += val;
    		sum[count++] = temp;
    	}
    	return sum;
    }

}
