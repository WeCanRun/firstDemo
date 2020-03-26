package com.wuyi.leetcode.blacktracking;

import java.util.ArrayList;
import java.util.List;

public class Solusion_131 {
    private List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    private void dfs(String s, int index, List<String> list){
        if(s.length() == index){
            res.add(new ArrayList<>(list));
            System.out.println("res: " + new ArrayList<>(list));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(isParty(s, index, i)){
                list.add(s.substring(index, i + 1));
                System.out.println("add: " + s.substring(index, i + 1));
                dfs(s, i + 1, list);
                System.out.println("remove: " + list.get(list.size() - 1));
                list.remove(list.size() - 1);

            }
        }
        return;
    }

    private boolean isParty(String s, int start, int end){
        System.out.println("is? " + s.substring(start, end + 1));
        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solusion_131 s = new Solusion_131();
        s.partition("aab");
    }

}
