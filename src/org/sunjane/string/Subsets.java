package org.sunjane.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0)
        	return res;
        List<Integer> pre = new ArrayList<Integer>();
        subHelp(nums, 0, pre);
        return res;
    }
    // [1,2,3,4] -> 0000~1111 bit mask
    private static void subHelp(int[] nums, int index, List<Integer> pre) {
    	List<Integer> t1 = new ArrayList<Integer>(pre);
    	List<Integer> t2 = new ArrayList<Integer>(pre);
    	t2.add(nums[index]);
    	if (index == nums.length - 1) {
    		res.add(t1);
    		res.add(t2);
    		return;
    	}
    	subHelp(nums, index + 1, t1);
    	subHelp(nums, index + 1, t2);
    }
    
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) 
        	return res;
        List<Integer> pre = new ArrayList<Integer>();
        Arrays.sort(nums);
        
        subHelp1(nums, 0, pre);
        return res;
        
    }
    
    // [1,2,3,4] -> 0000~1111 bit mask
    private static void subHelp1(int[] nums, int index, List<Integer> pre) {
    	List<Integer> preT = new ArrayList<Integer>(pre);
    	
    	if (index >= nums.length) {
    		res.add(preT);
    		return;
    	}
    	
    	int curVal = nums[index];
    	int curInd = index;
    	int count = 0;
    	
    	// count the times of duplicate num
    	while (index < nums.length) {
    		if (curVal == nums[index++]) {
    			count++;
    		} else {
    			break;
    		}
    	}
//    	System.out.println(index + " " + count);
    	int step = count;
    	subHelp1(nums, curInd + step, preT);
    	while (count-- > 0) {
    		preT.add(curVal);
    		subHelp1(nums, curInd + step, preT);
    	}
    }

}
