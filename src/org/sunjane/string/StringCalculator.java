package org.sunjane.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringCalculator {
	
	public class Solution {
	    public int calculate(String s) {
	        Deque<String> stack = new ArrayDeque<String>();
	        int len = s.length();
	        char ele;
	        int prio = 0;
	        int res = 0;
	        int temp;
	        for (int i = 0; i < len; i++) {
	        	ele = s.charAt(i);
	        	if (ele == ' ') continue;
	        	if (ele >= '0' && ele <= '9') {
	        		if (stack.isEmpty()) {
	        			stack.push(Character.toString(ele));
	        			continue;
	        		}
	        		
	        		if (prio == 1) {
	        			if (stack.pop().charAt(0) == '*') {
	        				temp = Integer.parseInt(stack.pop()) * 
	        						Character.getNumericValue(ele);
	        			} else {
	        				temp = Integer.parseInt(stack.pop()) / 
	        						Character.getNumericValue(ele);
	        			}
	        			res = temp;
	        			stack.push(Integer.toString(temp));
	        			prio = 0;
	        		} else {
	        			stack.push(Character.toString(ele));
	        		}
	        	} 
	        	if (ele == '*' || ele == '/') {
	        		prio = 1;
	        		stack.push(Character.toString(ele));
	        	} 
	        	if (ele == '+' || ele == '-') {
	        		prio = 0;
	        		stack.push(Character.toString(ele));
	        	}
	        		
	        }

	        int a,b;
	        while (!stack.isEmpty()) {
	        	a = Integer.parseInt(stack.pop());
	        	System.out.println(a);
	            if (stack.isEmpty()) 
	        	    return a;
	        	if (stack.pop().charAt(0) == '+') {
	        		b = Integer.parseInt(stack.pop());
	        		temp = a + b;
	        	} else {
	        		b = Integer.parseInt(stack.pop());
	        		temp = b - a;
	        	}
	        	res = temp;

	        	stack.push(Integer.toString(temp));
	        }
	        return res;
	    }
	}
}
