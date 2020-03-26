package com.wuyi.bishi.kuaishou;

import java.util.Scanner;

public class Main_2 {
    private static int next(int num){
        int res = 0;
        while(num != 0){
            res += (num % 10) * (num % 10);
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int m = sc.nextInt();
            sc.nextLine();
            while(m-- > 0){
                int n = sc.nextInt();
                sc.nextLine();
                int slow = n, fast = n;
                do{
                    slow = next(slow);
                    fast = next(fast);
                    fast = next(fast);
                } while(slow != fast);
                System.out.println( fast == 1 );
            }
    }
}

