package com.wuyi.bishi.weizhong;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long mul = 1;
        BigDecimal m = new BigDecimal(mul);
        for (long i = 1; i <= n; i++){
            m = m.multiply(new BigDecimal(i));
        }


        String str = m.toString();
        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) != '0'){
                System.out.println(str.charAt(i));
                break;
            }
        }
    }
}
