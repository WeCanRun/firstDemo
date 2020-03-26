package com.wuyi.notecode;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueue {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int data) {
        if (!q1.isEmpty()) {
            q1.add(data);
            return;
        }
        q2.add(data);
    }

    /*
    public int pop(){
        if (q1.isEmpty() && q2.isEmpty())
            return -1;

        while(!q1.isEmpty() && q1.size() != 1){
            int temp = q1.remove();
            q2.add(temp);
        }

        if (!q1.isEmpty())
            return q1.remove();
        else{
            while(!q2.isEmpty() && q2.size() != 1){
                int temp = q2.remove();
                q1.add(temp);
            }
        }

        return q2.remove();

    }

*/
    public int pop() {
        Queue<Integer> notEmpty;
        Queue<Integer> empty;

        if (q1.isEmpty() && q2.isEmpty())
            return -1;
        else if (q1.isEmpty()) {
            empty = q1;
            notEmpty = q2;
        } else {
            empty = q2;
            notEmpty = q1;
        }

        while(!notEmpty.isEmpty() && notEmpty.size() != 1){
            int temp = notEmpty.remove();
            empty.add(temp);
        }

        return notEmpty.remove();


    }

    public static void main(String[] args) {
        TwoQueue stack = new TwoQueue();

        for (int i = 0; i < 5; i++)
            stack.push(i);

        for (int i = 0; i < 5; i++)
            System.out.println(stack.pop());

    }
}
