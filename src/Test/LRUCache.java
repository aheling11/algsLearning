package Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int CACHE_SIZE = 10;

    public LRUCache(int cacheSize) {
        super((int)Math.ceil(cacheSize * 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.removeEldestEntry(eldest);
    }

    public void testSync(){
        ReentrantLock lock = new ReentrantLock();
        int[] a = new int[12];
        lock.lock();
        lock.unlock();

    }
}
