package com.ps.ccms.validation;

public final class Validator {

    public static boolean luhnCheck(String ccNumber) {
        int sum=0;
        boolean spOp = true;
        int lastDigit = Integer.parseInt(ccNumber.substring(ccNumber.length() - 1));
        ccNumber = new StringBuffer(ccNumber.substring(0, ccNumber.length() - 1)).reverse().toString();
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
        return true; //sum % 10 == lastDigit;
    }
}
