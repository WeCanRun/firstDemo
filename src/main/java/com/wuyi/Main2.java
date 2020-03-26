package com.wuyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[] l = new int[n];
        int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }

        int res = help(n, l, w);
        System.out.println(res);
    }

    private static int help(int n, int[] l, int[] w) {
        if (n > 100 || n < 1) {
            return 0;
        }

        int res = 0, weight = 0;
        Arrays.sort(l);
        Arrays.sort(w);
        for (int i = n - 1; i > 0; i--) {
            if (l[i] > 1000 || l[i] < 1 || w[i] > 1000 || w[i] < 1)
                return 0;
            int max = 0;
            for (int j = 0; j < n && weight < w[i] * 7; j++) {
                if (l[j] >= l[i])
                    continue;

                weight += w[j];
                max += 1;
            }
            if (max > res)
                res = max;

        }
        return res;
    }
}
