package org.sunjane.java;

import java.util.Arrays;
import java.util.Scanner;


public class Sort {
		private static Scanner scanner;
	
	public static void main1(String[] args) {

		scanner = new Scanner(System.in);
//		ArrayList<Integer> arrList = new ArrayList<Integer>();
		System.out.print("please input list number:");
		int len = scanner.nextInt();
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.print("before merge sort:");
		System.out.println(Arrays.toString(arr));
//		MergeSort.mergeSort(arr);
//		QuickSort.sort(arr);
		InsertSort.sort(arr);
		System.out.print("after merge sort:");
		System.out.println(Arrays.toString(arr));
		
	}
		
	
}

class MergeSort {
	private static int[] aux;

	// algo 4 version
	public static void sort(int[] a) {
		int N = a.length;
		aux = new int[N];
		for (int sz = 1; sz < N; sz *= 2) {
			for (int lo = 0; lo < N - sz; lo += sz * 2)
				merge(a, lo, lo + sz - 1, 
						Math.min(lo + sz * 2 - 1, N - 1));
		}

	}
	
	private static void merge(int[] arr, int lo, int mid, int hi) {
		
		int i = lo;
		int j = mid + 1;
		int k = lo;
		while (i <= mid && j <= hi) {
			aux[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}
		
		while (i <= mid) {
			aux[k++] = arr[i++];
		}
		while (j <= hi) {
			aux[k++] = arr[j++];
		}
		
		for (k = lo; k <= hi; k++)
			arr[k] = aux[k];
		
	}
	
	// wiki version
	public static void mergeSort(int[] arr) {
	    int len = arr.length;
	    int[] result = new int[len];
	    int block, start;
	    
	    for(block = 1; block < len*2; block *= 2) {
	        for(start = 0; start <len; start += 2 * block) {
	            int low = start;
	            int mid = (start + block) < len ? (start + block) : len;
	            int high = (start + 2 * block) < len ? (start + 2 * block) : len;
	            // two block first and last index
	            int start1 = low, end1 = mid;
	            int start2 = mid, end2 = high;
	            // merger two block
	            while (start1 < end1 && start2 < end2) {
		        result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
	            }
	            while(start1 < end1) {
		        result[low++] = arr[start1++];
	            }
	            while(start2 < end2) {
		        result[low++] = arr[start2++];
	            }
	        }
		int[] temp = arr;
		arr = result;
		result = temp;
	    }
	    result = arr;       
	}
	
}

class InsertSort {
	public static void sort(int[] arr) {
	    int len = arr.length;
	    int temp;
	    for (int i = 1; i < len; i++) {
	        temp = arr[i];
	        //insert arr[i] among arr[i-1], ..., arr[0]
	        int j = i - 1;
	        for (; j >= 0 ; j--) {
	            if (temp < arr[j]) {
	                arr[j + 1] = arr[j];
	            } else {
	                break;
	            }
	        }
	        arr[j + 1] = temp;
	    }
	    
	}
}

class QuickSort {
	static int[] arr;

	private static void swap(int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static void quickSortRecursive(int start, int end) {
		if (start >= end)
			return;
		int mid = arr[end];
		int left = start, right = end - 1;
		while (left < right) {
			while (arr[left] <= mid && left < right)
				left++;
			while (arr[right] >= mid && left < right)
				right--;
			swap(left, right);
		}
		if (arr[left] >= arr[end])
			swap(left, end);
		else
			left++;
		quickSortRecursive(start, left - 1);
		quickSortRecursive(left + 1, end);
	}

	public static void sort(int[] arrin) {
		arr = arrin;
		quickSortRecursive(0, arr.length - 1);
	}
}
