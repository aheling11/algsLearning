package concurrentLearning;

/**
 * 继承 Thread 类创建线程对象
 * @author Jeff Lee @ bysocket.com
 * @since 2018年01月27日21:03:02
 */
public class MyThread extends Thread {

    @Override // 可以省略
    public void run() {
        System.out.println("MyThread 的线程对象正在执行任务");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyThread thread = new MyThread();
            thread.start();

            System.out.println("MyThread 的线程对象 " + thread.getId());
        }
    }
}