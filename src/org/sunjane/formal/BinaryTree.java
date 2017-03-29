package org.sunjane.formal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String[] nodes = in.next().split(",");
		TreeNode root = TreeNode.createTree(nodes);
		TreeNode.preOrderTree(root);
//		System.out.println(scanner.next());
//		System.out.println(scanner);

	       
	}


}

