package com.wuyi.bishi.weizhong;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Main_2 main = new Main_2();
        String answer = main.answer(n);
        System.out.println(answer);
    }

    private String answer(int n) {
        int bit = 1;
        int i = 0, j = 0, cnt = 0;
        do {
          if((bit & n) == bit)
              i = bit;
          else
              j = bit;
          bit <<= 1;
          cnt++;
        } while (bit < n + 1);

        while(i <= n){
            if (i == n)
                break;
            i++;
            cnt++;
        }

        long mul = 1;
        BigDecimal m = new BigDecimal(mul);
        for (long k = 1; k <= cnt; k++){
            m = m.multiply(new BigDecimal(k));
        }

        m = m.divideAndRemainder(new BigDecimal(Math.pow(10, 6) + 3))[1];
        return m.toString();
    }
}
