package concurrentLearning;

public class SolutionTask {

    static class ThreadTask implements Runnable{
        static int value = 0;
        @Override
        public void run() {
            while (value <= 100){
                synchronized (ThreadTask.class){

                }
            }
        }
    }
}
