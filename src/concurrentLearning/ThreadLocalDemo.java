package concurrentLearning;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        ThreadLocalDemo.begin();
        TimeUnit.SECONDS.sleep(10);
        System.out.println("Cost:" + end());

    }
}
