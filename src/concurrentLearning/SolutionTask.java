package concurrentLearning;

import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class SolutionTask {
    private static final ExecutorService EXECUTOR = new ThreadPoolExecutor(30, 30, 2, TimeUnit.MINUTES, new LinkedBlockingDeque<>());

    public static void main(String[] args) {
    }
}
