package com.wuyi.notecode;


import java.util.Scanner;

public class StackApplication {
    //括号匹配算法
    static boolean isMatch(String curString) {
        LLStack<Character> stack = new LLStack<>();
        //字符处理
        for(int i = 0; i < curString.length(); i++) {
            char ch = curString.charAt(i);
            switch(ch) {
                case '(' :
                    stack.push(ch);
                    break;
                case '[' :
                    stack.push(ch);
                    break;
                case '{' :
                    stack.push(ch);
                    break;
                case ')' :
                    if(stack.isEmpty() || stack.top().equals('c')) {
                        System.out.println("括号匹配失败");
                        return false;
                    }else {
                        stack.pop();
                    }
                    break;
                case ']' :
                    if(stack.isEmpty() || stack.top().equals('[') ) {
                        System.out.println("括号匹配失败");
                        return false;
                    }else {
                        stack.pop();
                    }
                    break;
                case '}' :
                    if(stack.isEmpty() || stack.top().equals('{') ) {
                        System.out.println("括号匹配失败");
                        return false;
                    }else {
                        stack.pop();
                    }
                    break;
            }
        }
        //字符处理后栈非空
        if(!stack.isEmpty()) {
            System.out.println("括号匹配失败");
            return false;
        }
        //System.out.println("括号匹配成功");
        return true;
    }
    //算术符号优先级算法
    static boolean isPriority(char top, char t) {
        /*if(nums == '(' || nums == '[' || nums == '{') return true;
        if(b == '(' || b == '[' || b == '{' ) return true;

        if(b == '*' || b == '/' || b == '%')
            return false;
        else if(nums == '*' || nums == '/' || nums == '%')
            return true;
        else if(b == '+' || b == '-' )
            return false;
        else return true;
*/
        if((t == '+' || t == '-') && (top == '*' || top == '/'))
            return true;
        return false;

    }

    static boolean isNumber(char t){
        //这里为了测试一下字母，所以把字母也加进来了
        if (t >= '0' && t <= '9' || t >= 'a' && t <= 'z' || t >= 'A' && t <= 'Z' )
            return  true;
        return false;
    }
    //中缀转后缀算法
    static String MinddleTurnToBack(String curString) {
        LLStack<Character> stack = new LLStack<>();
        String result = "" ;
        System.out.print("中缀表达式转换为后缀表达式：");
        for(int i = 0; i < curString.length(); i++) {
            char t = curString.charAt(i);
            if(isNumber(t)) {
                //数字直接输出
                System.out.print(t);
                result = result + t;
            }else if((t == ')' || t == ']' || t == '}')) {
                //当栈顶不是‘（’时，出栈并输出
                while(!stack.isEmpty() && stack.top() != '(' && stack.top() != '[' && stack.top()!= '{'){
                    result += stack.top();
                    System.out.print((char)stack.pop());

                }
                //直到栈顶是‘（’
                if (!stack.isEmpty())
                    stack.pop();

            }else {//操作符或‘(’
                //当栈非空且t的优先级不大于栈顶元素时，出栈并输出然后t入栈
                while(!stack.isEmpty() && isPriority((char)stack.top(), t)) {
                    result += stack.top();
                    System.out.print((char)stack.pop());
                }
                stack.push(t);
            }
        }
        while(!stack.isEmpty()) {
            result += stack.top();
            System.out.print((char)stack.pop());
        }
        System.out.println();
        return result;
    }
    //计算后缀表达式算法
    static Double calculator(String curString) {
        LLStack<Double> stack = new LLStack<>();
        for(int i = 0; i < curString.length(); i++) {
            String t = curString.substring(i , i + 1 );
            if(t.charAt(0) >= '0' && t.charAt(0) <= '9' ) {
                //数字直接入栈
                stack.push(Double.parseDouble(t));
            }else {
                double a , b = 0;
                a =(Double) stack.pop();
                b =(Double) stack.pop();
                switch(t){
                    case "*" : stack.push(b * a);System.out.println(t+":" + b * a);break;
                    case "/" : stack.push(b / a);System.out.println(t+":" + b / a);break;
                    case "+" : stack.push(b + a);System.out.println(t+":" + (double)(b + a));break;
                    case "-" : stack.push(b - a);break;
                    case "%" : stack.push(b % a);break;
                }
            }
        }
        return stack.pop() ;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String curString = null;
        while(true) {
            System.out.print("请输入中缀表达式：");
            curString = scanner.next();
            if(isMatch(curString))
                System.out.println("计算出后缀表达式的结果为：" + calculator(MinddleTurnToBack(curString)));
            //MinddleTurnToBack(curString);
            System.out.println();
        }
    }
}

