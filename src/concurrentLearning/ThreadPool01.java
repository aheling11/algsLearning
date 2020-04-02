package concurrentLearning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool01 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()-> System.out.println("Hello HeLing"));
    }
}
