package org.sunjane.weekly;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JudgeDate {
	public static void main(String[] args) {
		Map<Long, Long> map = new HashMap<Long, Long>();
		Scanner in = new Scanner(System.in);
		long N = in.nextLong();
		long M = in.nextLong();
		long sqrtN = (long)(Math.sqrt(N));
		long sqrtM = (long)(Math.sqrt(M));
		long count = 0;
//		long y = 0;
		for (long i = 1; i <= sqrtN; i++) {
			if (N % i == 0) {
				if (!map.containsKey(i)) {
					map.put(i, 1L);
					map.put(N / i, 1L);
					if (i == N / i)
						count += 1;
					else
						count += 2;
				}
//				y += 2;
			}
		}
		long count1 = 0;
		long same = 0;
		for (long i = 1; i <= sqrtM; i++) {
			if (M % i == 0) {
				if (map.containsKey(i)) {
					same++;
				} 
				if (map.containsKey(M / i) && (M / i != i)) {
					same++;
				}
				if (M / i == i) 
					count1 += 1;
				else 
					count1 += 2;
			}
		}
//		System.out.println(count + " " + count1 + " " + same);
		long gcdVal = gcd(count * count1, same);
		long A = count * count1 / gcdVal;
		long B = same / gcdVal;		
		
		
		
		
		System.out.println(A + " " + B);
	}
	
	// a >= b
	private static long gcd(long a, long b) {
		long c = a % b;
		while (c != 0) {
			a = b;
			b = c;
			c = a % b;
		}
		return b;
	}
}
