package org.sunjane.string;

public class ComplexMultiple {
    public static String complexNumberMultiply(String a, String b) {
        String[] aa = a.split("\\+");
        String[] bb = b.split("\\+");
        int[] res = new int[4];
        res[0] = Integer.parseInt(aa[0]) * Integer.parseInt(bb[0]);
        res[1] = Integer.parseInt(aa[0]) * Integer.parseInt(bb[1].substring(0, bb[1].length() - 1));
        res[2] = Integer.parseInt(aa[1].substring(0, aa[1].length() - 1)) * Integer.parseInt(bb[0]);
        res[3] = Integer.parseInt(aa[1].substring(0, aa[1].length() - 1)) *
        		Integer.parseInt(bb[1].substring(0, bb[1].length() - 1));
        res[0] = res[0] - res[3];
        res[1] = res[1] + res[2];
        String result = res[0] + "+" + res[1] + "i";
        return result;
    }
}
