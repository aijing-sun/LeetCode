package org.sunjane.string;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class StringCalculator {
	
	public static class Solution {
	    public static int calculate(String s) {
	        Deque<String> stack = new ArrayDeque<String>();
	        int len = s.length();
	        int temp;
	        String[] eles = s.split("\\*|\\+|/|-");
//	        System.out.print(Arrays.toString(eles));
	        int counter = 1; // counter for integers 
	        stack.push(eles[0].trim());
	        char ele;
	        for (int i = 0; i < len; i++) {
	        	ele = s.charAt(i);
	        	if (ele == '*') {
	        		stack.push(String.valueOf(
	        				Integer.parseInt(stack.pop())
	        				* Integer.parseInt(eles[counter++].trim())));
	        	} else if (ele == '/') {
	        		stack.push(String.valueOf(
	        				Integer.parseInt(stack.pop())
	        				/ Integer.parseInt(eles[counter++].trim())));
	        	}
	        	if (ele == '+' || ele == '-') {
	        		stack.push(Character.toString(ele));
	        		stack.push(eles[counter++].trim());
	        	}
	        		
	        }

	        int res = 0;
	        // remove the first element in the stack
	        res = Integer.parseInt(stack.removeLast());
	        while (!stack.isEmpty()) {
	        	if (stack.removeLast().charAt(0) == '+') {
	        		res += Integer.parseInt(stack.removeLast());
	        	} else {
	        		res -= Integer.parseInt(stack.removeLast());
	        	}
	        }
	        return res;
	    }
	}
	
	/*
	 public int calculate(String s) {
    int len;
    if(s==null || (len = s.length())==0) return 0;
    Stack<Integer> stack = new Stack<Integer>();
    int num = 0;
    char sign = '+';
    for(int i=0;i<len;i++){
        if(Character.isDigit(s.charAt(i))){
            num = num*10+s.charAt(i)-'0';
        }
        if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
            if(sign=='-'){
                stack.push(-num);  // smart trick
            }
            if(sign=='+'){
                stack.push(num);
            }
            if(sign=='*'){
                stack.push(stack.pop()*num);
            }
            if(sign=='/'){
                stack.push(stack.pop()/num);
            }
            sign = s.charAt(i);
            num = 0;
        }
    }

    int re = 0;
    for(int i:stack){
        re += i;
    }
    return re;
}
	 
	 
	  */
}
