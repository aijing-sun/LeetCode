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
		System.out.println(Integer.parseInt("01"));
		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println(a == c);
		System.out.println(b == c);
		System.out.println(Integer.highestOneBit(127));
		 String s1 = "Programming";
	        String s2 = new String("Programming");
	        String s3 = "Program";
	        String s4 = "ming";
	        String s5 = "Program" + "ming";
	        String s6 = s3 + s4;
	        System.out.println(s1.hashCode() == s2.hashCode());
	        System.out.println(s1 == s5);
	        System.out.println(s1 == s6);
	        System.out.println(s1 == s6.intern());
	        System.out.println(s2 == s2.intern());

		
	}

}
