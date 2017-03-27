package org.sunjane.java;

public class CommonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		testEqual();
	}
	
	private static void testEqual() {
		
		Integer a = new Integer(1);
		Integer b = 1;
		int c = 1;
		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println(a == c);
		System.out.println(b == c);
		System.out.println(Integer.highestOneBit(127));
		
	}

}
