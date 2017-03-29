package org.sunjane.formal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
		this.left = null;
		this.right = null;
	}
	
	TreeNode() {
		this.left = null;
		this.right = null;
	};
	
	// tree is like [1, 2, 3, 4, null, 5] in layer order. where
	// null is empty node
	public static TreeNode createTree(String[] nodes) {
		ArrayList<TreeNode> q = new ArrayList<TreeNode>();
		if (nodes.length == 0) return new TreeNode();
		TreeNode curNode;
		for (String val : nodes) {
			if (val == null) {
				curNode = null;
			} else {
				curNode = new TreeNode(Integer.parseInt(val)); 
			}
			q.add(curNode);
		}
		int len = nodes.length;
		int index;
		for (int i = 0; i < len; i++) {
			curNode = q.get(i);
			index = 2 * i + 1;
			if (index == len) break;
			if (q.get(index) != null) {
				curNode.left = q.get(index);
			}
			index = 2 * (i + 1);
			if (index == len) break;
			if (q.get(index) != null) {
				curNode.right = q.get(index);
			}
		}
		return q.get(0);
	}
	
	public static void preOrderTree(TreeNode root) {
		if (root == null) return;
		System.out.println(root.val);
		preOrderTree(root.left);
		preOrderTree(root.right);
	}
}

class TreeLinkNode extends TreeNode {
	   int val;
	   TreeLinkNode left, right, next;
}
