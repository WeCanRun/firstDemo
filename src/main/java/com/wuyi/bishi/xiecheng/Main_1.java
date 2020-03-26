package com.wuyi.bishi.xiecheng;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main_1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        Stack<String> stack = new Stack<>();
        Queue <String> queue = new LinkedList<>();
        char [] str = expr.toCharArray();
        for (int i = 0;i < str.length;i++) {
            if (str[i] == ')') {
                while(!stack.isEmpty() && !stack.peek().equals("(")) {
                    queue.add(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                }else{
                    return "";
                }
                while (!queue.isEmpty()) {
                    stack.add(queue.remove());
                }
            }else {
                stack.push(str[i] + "");
            }

        }
        StringBuffer res = new StringBuffer("");
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            if (stack.peek().equals("(") || stack.peek().equals(")")) {
                return "";
            }
            res.append(stack.pop());
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
