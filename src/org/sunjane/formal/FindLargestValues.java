package org.sunjane.formal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Input: 

    1
   / \
  3   2
 / \   \  
5   3   9 

Output: [1, 3, 9]
*/

public class FindLargestValues {
	public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root != null) {
            queue.offer(root);
        }
        
        // use these two variables to track level node number
        int parentSize = 1;
        int childSize = 0;
        
        int tempMax = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
        	
        	
        	TreeNode node = queue.poll();
        	tempMax = Math.max(tempMax, node.val);
        	parentSize--;
        	if (node.left != null) {
        		queue.offer(node.left);
        		childSize++;
        	}
        	if (node.right != null) {
        		queue.offer(node.right);
        		childSize++;
        	}
        	
        	if (parentSize == 0) {
        		res.add(tempMax);
        		parentSize = childSize;
        		childSize = 0;
        		tempMax = Integer.MIN_VALUE;
        	}

        	
        }
        
        
		return res;
    }
	
	
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    // recursive version faster 
    // use depth as appropriate position for the result
    // here use pre-order traverse idea. mid or post-order can work too.
    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
       //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
        //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }
	
}
