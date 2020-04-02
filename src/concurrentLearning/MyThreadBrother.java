package concurrentLearning;

/**
 * 实现 Runnable 接口类创建线程对象
 * @author Jeff Lee @ bysocket.com
 * @since 2018年01月27日21:22:57
 */
public class MyThreadBrother implements Runnable {

    @Override // 可以省略
    public void run() {
        System.out.println("MyThreadBrother 的线程对象正在执行任务");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new MyThreadBrother());
            thread.start();

            System.out.println("MyThreadBrother 的线程对象 " + thread.getId());
        }
    }
}