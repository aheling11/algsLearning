package concurrentLearning;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPool01 {

    private static final ExecutorService EXECUTOR = new ThreadPoolExecutor(30, 30, 2, TimeUnit.MINUTES, new LinkedBlockingDeque<>());

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }

        for (String s : list) {
            EXECUTOR.submit(()->{
                System.out.println(s);
            });
        }


    }
}
