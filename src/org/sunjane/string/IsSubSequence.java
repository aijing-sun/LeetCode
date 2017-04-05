package org.sunjane.string;

public class IsSubSequence {
	public static boolean isSubsequence(String s, String t) {
//		int[] map = new int[26];
		if (s.length() == 0) return true;
		char[] tArr = t.toCharArray();
		char[] sArr = s.toCharArray();
		int i = 0, j = 0;
		int res = 0;
		while (j < sArr.length && i < tArr.length) {
			if (tArr[i] == sArr[j]) {
				res += 1;
				if (res == sArr.length) return true;
				i++;
				j++;
			} else {
				i++;
			}
		}
		return false;
		
	}
}
