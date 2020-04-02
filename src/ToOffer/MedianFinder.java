package ToOffer;

import java.util.PriorityQueue;

class MedianFinder {
    int size = 0;
    PriorityQueue<Integer> maxqueue = new PriorityQueue<>();
    PriorityQueue<Integer> minqueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    /** initialize your data structure here. */
    public MedianFinder() {

    }
    
    public void addNum(int num) {
        if (maxqueue.isEmpty()){
            maxqueue.add(num);
        } else if (num >= maxqueue.peek()){
            maxqueue.add(num);
            if (maxqueue.size() > minqueue.size() + 1){
                minqueue.add(maxqueue.poll());
            }
        } else {
            minqueue.add(num);
            if (minqueue.size() > maxqueue.size()){
                maxqueue.add(minqueue.poll());
            }
        }
        size++;
    }
    
    public double findMedian() {
        if (size == 0){
            return 0;
        }
        if ((size & 1) == 1){
            return maxqueue.peek();
        } else {
            return (maxqueue.peek() + minqueue.peek())/2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(12);
        obj.addNum(10);
        obj.addNum(13);
        obj.addNum(11);
        obj.addNum(5);

        System.out.println(obj.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */