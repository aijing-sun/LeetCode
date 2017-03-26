package org.sunjane.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static List<Integer> getRow(int rowIndex) {
        Integer[] rows = new Integer[rowIndex + 1];
        rows[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            rows[i] = 1;
            for (int j = i - 1; j > 0; j--) {
                rows[j] = rows[j] + rows[j - 1];
            }
        }
//        List<Integer> res = new ArrayList<Integer>();
        return Arrays.asList(rows);
    }
    
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) return res;
        Integer[] preRow = new Integer[1];
        preRow[0] = 1;
        res.add(Arrays.asList(preRow));
        for (int i = 1; i < numRows; i++) {
        	Integer[] curRow = new Integer[i + 1];
        	curRow[0] = 1;
        	curRow[i] = 1;
        	for (int j = 0; j < i - 1; j++) {
        		curRow[j + 1] = preRow[j] + preRow[j + 1];
        	}
        	res.add(Arrays.asList(curRow));
//        	System.out.println(Arrays.asList(curRow));
        	preRow = curRow;
        }
        return res;
    }
}
