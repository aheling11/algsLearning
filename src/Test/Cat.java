package Test;

import edu.princeton.cs.algs4.In;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cat extends Animal implements Mate{

    public class MyThread extends Thread{


    }

    public Cat(String name, int age) {
        super(name, age);
    }

    public static void main(String[] args) throws InterruptedException {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.getOrDefault(2,0);
        Cat cat = new Cat("alice", 12);
        cat.eat();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        Iterator it = a.iterator();
        while (it.hasNext()){
            Integer t = (Integer) it.next();
            System.out.println(t);
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("abc");
        sb2.append("tttttttt");
        StringBuffer sbf = new StringBuffer();
        sbf.append("123");
        String c = new String("aa");
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.lockInterruptibly();

    }




}
