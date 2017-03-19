package org.sunjane.formal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindFrequentTreeSum {

/*
 refer to https://leetcode.com/problems/most-frequent-subtree-sum/?tab=Description
 */
	
	HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();
	int maxFreTimes = 0;
	int temp;
    public int[] findFrequentTreeSum(TreeNode root) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	
    	
    	subTreeSum(root);
    	
//    	if (sums.isEmpty()) return null;
    	for (Map.Entry<Integer, Integer> entry : sums.entrySet()) {
    		if (entry.getValue() == maxFreTimes) {
    			res.add(entry.getKey());
    		}
    	}
    	
    	int[] ress = new int[res.size()];
    	int i = 0;
    	for (int v : res) {
    		ress[i++] = v;
    	}

		return ress;
       
    }
    
    private int subTreeSum(TreeNode root) {
    	if (root == null) return 0;
    	int sum = root.val;
    	sum += subTreeSum(root.left); 
    	sum += subTreeSum(root.right); 
    	if (sums.containsKey(sum)) {
    		temp = sums.get(sum) + 1;
    		sums.replace(sum, temp);
//    		sums.equals(root.val);
//    		sums.hashCode();
    		
    	} else {
    		temp = 1;
    		sums.put(sum, 1);
    	}
  	    maxFreTimes = Math.max(maxFreTimes, temp);
    	return sum;
    	
    }
}
