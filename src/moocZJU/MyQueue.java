package moocZJU;

public class MyQueue {

    int[] arr = new int[5];
    int head = 0;
    int tail = 0;
    int size = 0;
    public void push(int x){
        if (size == arr.length){
            System.out.println("数组已满");
            return;
        }
        size ++;
        arr[tail] = x;
        tail = tail == arr.length - 1 ? 0 : tail + 1;
    }

    public int poll(){
        if (size == 0){
            System.out.println("数组为空");
            return -1;
        }
        size--;
        int tmp = head;
        head = head == arr.length - 1 ? 0 : head + 1;
        return arr[tmp];
    }



    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(5);
        queue.push(4);
        queue.push(3);
        System.out.println(queue.poll());
        queue.push(2);
        queue.push(1);
        queue.push(0);
        queue.push(0);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }
}
