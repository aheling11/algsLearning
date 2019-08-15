package moocZJU;


//用数组实现栈
public class MyStack {
    int maxsize = 10;
    Object[] dataList = new Object[maxsize];
    int top = -1;
    //入栈
    public void push(Object data) {
        if (top == maxsize) {
            System.out.println("堆栈满");
            return;
        }
        dataList[++top] = data;
    }
    //出栈
    public Object pop() {
        if (top == -1) {
            System.out.println("堆栈为空");
            return -1;
        }
        return dataList[top--];

    }



    public static void main(String args[]) {
        MyStack s = new MyStack();
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

}
