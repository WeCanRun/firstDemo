package com.wuyi.notecode;


class LLNode<T>{
    private T data;
    private LLNode next = null;

    public LLNode(T d){
        data = d;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public LLNode getNext() {
        return next;
    }
    public void setNext(LLNode next) {
        this.next = next;
    }


}
public class LLStack<T> {
    private LLNode<T>  head;

    boolean isEmpty() {
        return head == null;
    }

    int size() {
        int count = 1;
        LLNode cur = head;
        if(isEmpty())  return 0;
        while(cur.getNext() !=null ) {
            cur = cur.getNext();
            count++;
        }
        return count;
    }

    T top() {
        if(isEmpty())
            new Exception("栈空");
        return head.getData();
    }

    void push(T d) {
        if(isEmpty()) {
            head =new LLNode(d);
        }else {
            LLNode node = new LLNode(d);
            node.setNext(head);
            head = node;
        }
    }

    T pop() {
        if(isEmpty())
            new Exception("栈空");
        LLNode<T> del = head;
        head = head.getNext();
        return del.getData();
    }
    void display() {
        if(isEmpty()) {
            System.out.println("栈空");
        }else {
            LLNode cur = head;
            System.out.print("栈内元素：");
            while(cur != null) {
                System.out.print(cur.getData() + "->");
                cur = cur.getNext();
            }
            System.out.println();
        }
    }

    void deleteStack() {
        head  = null;
    }



    public static void main(String[] args) {
        LLStack<Character> ls = new LLStack<>();
        ls.push('2');
        ls.push('3');
        System.out.println("栈顶元素：" + ls.top());
        ls.display();
        System.out.println("移除栈顶元素：" + ls.pop());
        ls.push('5');
        System.out.println("删除整个栈");
        ls.deleteStack();
        ls.display();

    }

}

