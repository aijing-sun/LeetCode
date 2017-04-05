package org.sunjane.weekly;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ShortSeq {

	
	// another idea from http://blog.csdn.net/dumeichen/article/details/52785133
	// the final array only left pure even or odd numbers
	// because when existing both, they can be removed
	// so the left minimum is |even - odd|
	
	// use stack
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
        Deque<Integer> stack = new LinkedList<Integer>();
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
			if (stack.isEmpty()) {
				stack.push(arr[i]);
			} else {
				if ((arr[i] + stack.peek()) % 2 == 1) {
					stack.pop();
				} else {
					stack.push(arr[i]);
				}
			}
		}
		
		
		System.out.println(stack.size());
	}

}
