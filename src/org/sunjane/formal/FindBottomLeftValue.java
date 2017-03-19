package org.sunjane.formal;

public class FindBottomLeftValue {

	
/*
example
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
 */

	int maxDepth = -1;
	int res;
    public int findBottomLeftValue(TreeNode root) {
        
        if (root == null) return 0;
        preOrderFind(root, 0);
    	return res;
    }
    
    private void preOrderFind(TreeNode root, int depth) {
    	
    	if (root.left == null && root.right == null) {
    		if (depth > maxDepth) {
    			res = root.val;
    			maxDepth = depth;
    		}
    	}
    	
    	if (root.left != null) {
    		
    		preOrderFind(root.left, depth + 1);
    	}
    	
    	if (root.right != null) {
    		preOrderFind(root.right, depth + 1);
    	}
    	
    }
}
