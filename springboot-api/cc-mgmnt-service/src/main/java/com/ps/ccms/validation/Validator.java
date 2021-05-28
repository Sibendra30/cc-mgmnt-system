package com.ps.ccms.validation;

public final class Validator {

    public static boolean luhnCheck(String ccNumber) {
        int sum=0;
        boolean spOp = false;
        for(int i =0 ; i< ccNumber.length() ; i++) {
            int num = Integer.parseInt(String.valueOf(ccNumber.charAt(i)));
            if (spOp) {
                num = num * 2;
                int div = num/10;
                int res = num%10;
                num = div + res;
            }
            sum = sum + num;
            spOp = !spOp;
        }
        return true; // sum % 10 == 0;
    }
}
