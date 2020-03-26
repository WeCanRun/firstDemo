package com.wuyi.bishi.xiecheng;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main_2 {

    private static int[] index = new int[5000010];
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
       StringBuilder res = new StringBuilder();
       LinkedList<Integer> stack = new LinkedList<>();
       for(int i = 0; i < expr.length();i++){
           char c = expr.charAt(i);
           if(c == '('){
               stack.push(i);
           } else if(c == ')'){
               if(stack.isEmpty())
                   return null;

               int top = stack.pop();
               index[i] = top;
               index[top] = i;
           }
       }
        if (!stack.isEmpty())
            return null;

        int cre = 1;
        for(int i = 0; i < expr.length();){
            char c = expr.charAt(i);
            if(c == '(' || c == ')'){
                i = index[i];
                cre = -cre;
            } else
                res.append(c);

            i += cre;
        }

       return res.toString();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
