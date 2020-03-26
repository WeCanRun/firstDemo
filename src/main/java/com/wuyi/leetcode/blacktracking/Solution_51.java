package com.wuyi.leetcode.blacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_51 {

    boolean[] cols;
    boolean[] d1;
    boolean[] d2;
    int n;
    List<String> list;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        d1 = new boolean[2 * n];
        d2 = new boolean[2 * n];
        res = new ArrayList<>();
        this.n = n;
        this.list = new ArrayList<>();
        helper(0);
        return res;
    }

    private void helper(int row) {
        if (n == row) {
            res.add(new ArrayList<>(list));
            return;
        }
        char[] temp = new char[n];
        Arrays.fill(temp, '.');

        for (int c = 0; c < n; c++) {
            int id1 = row + c;
            int id2 = row - c + n;
            if (cols[c] || d1[id1] || d2[id2])
                continue;
            cols[c] = true;
            d1[id1] = true;
            d2[id2] = true;
            temp[c] = 'Q';
            list.add(new String(temp));
            helper(row + 1);
            temp[c] = '.';
            cols[c] = false;
            d1[id1] = false;
            d2[id2] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution_51 s = new Solution_51();
        s.solveNQueens(4);
        for (List t : s.res) {
            System.out.println(t);
        }
    }
}
