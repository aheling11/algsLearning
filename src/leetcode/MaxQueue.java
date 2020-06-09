package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MaxQueue {

    Queue<Integer> queue = new LinkedList<>();
    LinkedList<Integer> dequeue = new LinkedList<>();

    public MaxQueue() {

    }
    
    public int max_value() {
        return dequeue.isEmpty() ? -1 : dequeue.getFirst();
    }
    
    public void push_back(int value) {
        queue.add(value);
        while (!dequeue.isEmpty() && dequeue.getLast() < value){
            dequeue.pollLast();
        }
        dequeue.addLast(value);

    }
    
    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        Integer ans = queue.poll();
        if (ans.equals(dequeue.getFirst())){
            dequeue.pollFirst();
        }
        return ans;
    }

    public static void main(String[] args) {

        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.push_back(4);
        maxQueue.push_back(4);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(222);
        System.out.println(maxQueue.max_value());
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */