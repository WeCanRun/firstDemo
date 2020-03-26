package com.wuyi.leetcode.stackandqueue;

import java.util.*;

public class Solution_347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int a : nums)
            map.put(a, map.getOrDefault(a, 0) + 1);


        PriorityQueue<Integer> pq = new PriorityQueue<>((m1,m2) -> map.get(m1) - map.get(m2));

        for(int key : map.keySet()){
            if(k > 0){
                k--;
                pq.offer(key);
            } else if(map.get(key) > map.get(pq.peek())){
                pq.poll();
                pq.offer(key);
            }
        }

        for(int m : pq){
            res.add(m);
        }

        return res;
    }
}