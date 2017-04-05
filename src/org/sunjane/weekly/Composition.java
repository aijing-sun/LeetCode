package org.sunjane.weekly;

import java.util.Scanner;

// refer to http://hihocoder.com/discuss/question/3975 
public class Composition {
	public static void main1(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String comp = in.next();
		int confNum = in.nextInt();
		final int NUM = 26;
		boolean[][] conflict = new boolean[NUM][NUM];
		String confs;
		for (int i = 0; i < confNum; i++) {
			confs = in.next();
			int first = confs.charAt(0) - 'a';
			int second = confs.charAt(1) - 'a';
			conflict[first][second] = true;
			conflict[second][first] = true;
		}
		
		
		int[] arr = new int[NUM]; // first all characters are 0
		int maxLen = 0;
		for (int i = 0; i < N; i++) {
			int index = comp.charAt(i) - 'a';
			int max = 0;
			for (int j = 0; j < NUM; j++) {
				if (!conflict[index][j]) {
					// get max length for ahead composition ending with 'arr[j]'
					max = Math.max(max, arr[j]); 
				}
			}
			arr[index] = max + 1;
//			System.out.println(i + " " + max);
			maxLen = Math.max(arr[index], maxLen);
		}
		
		System.out.println(N - maxLen);
	}
}
