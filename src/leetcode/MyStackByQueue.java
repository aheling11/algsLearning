package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyStackByQueue {

    Queue<Integer> s1 = new LinkedList<>();
    Queue<Integer> s2 = new LinkedList<>();

    int top = 0;
    /** Initialize your data structure here. */
    public MyStackByQueue() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        top = x;
        s1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!s1.isEmpty()){
            while (s1.size() > 1){
                top = s1.poll();
                s2.add(top);
            }
        }
        int result =  s1.poll();
        Queue<Integer> temp = s1;
        s1 = s2;
        s2 = temp;
        return result;
    }
    
    /** Get the top element. */
    public int top() {
        if (!empty()){
            return top;
        }
        return -1;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        MyStackByQueue s = new MyStackByQueue();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.top());



    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */