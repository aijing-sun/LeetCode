package org.sunjane.formal;

import java.util.Scanner;

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
//		System.out.println(scanner.next());
//		System.out.println(scanner);
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

