package org.sunjane.hihocoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MemAlloc {

	Map<Integer, Integer> memIndex = new HashMap<Integer, Integer>();
	int earliest = 0;
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		int mem = in.nextInt();
		int[] arr = new int[number];
		for (int i = 0; i < number; i++) {
			arr[i] = in.nextInt();
		}
		int index = 0;
		for (int i = 0; i < number; i++) {
			
		}

	}
	
//	private boolean alloc(int[] arr, int index, int size) {
////		if (index + size >= arr.length) return false;
////		index = memIndex.
//		if (index + size >= arr.length) {
//			index = 0;
//		}
//		int temp = -1;
//		int lastIndRm = 0;
//		for (int i = index; i < size; i++) {
//			if (arr[i] != 0) {
//				if (temp != arr[i]) {
//					temp = arr[i];
////					lastIndRm
//				}
//				arr[i] = 0;
//			}
//		}
//	}

}
