package com.wuyi.notecode;

public class KMP {

    private int[] next;

    public int KMP(String T, String P){
        // 先构造 next 数组
        createNext(P);

        for(int i = 0, j = 0; i < T.length();){
            if (j == P.length() - 1)
                return i - j;

            if (j == 0 || T.charAt(i) == P.charAt(j)){
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return -1;
    }

    private void createNext(String P) {
        next = new int[P.length()];
        next[0] = 0;

        for (int i = 1, j = 0;i < P.length();){
            if (j == 0 || P.charAt(i - 1) == P.charAt(j - 1)){
                //j - 1 代表前缀的最后一个索引，i - 1 代表后缀的最后一个索引
                //next[i] = j;
                if (P.charAt(i) != P.charAt(j))
                    next[i] = j;
                else
                    next[i] = next[j];
                i++;
                j++;
            } else {
                // 若字符不相等，则 j 值回溯
                j = next[j];
            }
        }
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        int res = kmp.KMP("aaaabdef","aaaaax");
        for (int a : kmp.next){
            System.out.print(a + " ");
        }
        System.out.println("\nres:" + res);

    }
}
