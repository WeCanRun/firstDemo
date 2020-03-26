package com.wuyi.leetcode.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_901 {
    private LinkedList<Integer> nums;
    private LinkedList<Integer> dp;

    public Solution_901() {
        nums = new LinkedList<>();
        dp = new LinkedList<>();
    }

    public int next(int price) {
        int res = 1;
        while(!nums.isEmpty() && nums.peekLast() <= price){
            nums.pollLast();
            res += dp.pollLast();
        }
        nums.offerLast(price);
        dp.offerLast(res);
        return res;
    }



    public static void main(String[] args) {
        Solution_901 s = new Solution_901();
        List<Integer> res  = new ArrayList<>();
        res.add(s.next(100));
        res.add(s.next(80));
        res.add(s.next(60));
        res.add(s.next(70));
        res.add(s.next(60));
        res.add(s.next(75));
        res.add(s.next(85));

        System.out.println(res);
    }
}
