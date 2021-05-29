package com.ps.ccms.validation;

public final class Validator {

    public static boolean luhnCheck(String ccNumber) {
        int sum=0;
        boolean spOp = true;
        int lastDigit = Integer.parseInt(ccNumber.substring(ccNumber.length() - 1));
       // ccNumber = new StringBuffer(ccNumber.substring(0, ccNumber.length() - 1)).reverse().toString();
        for(int i = ccNumber.length() - 2 ; i >= 0 ; i--) {
            int num = Integer.parseInt(String.valueOf(ccNumber.charAt(i)));
            if (spOp) {
                num = num * 2;
                num = num/10 +  num%10;
            }
            sum = sum + num;
            spOp = !spOp;
        }

        return (10 - (sum % 10) == lastDigit);
    }
}
