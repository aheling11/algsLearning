package Test;

import edu.princeton.cs.algs4.In;
import utils.TreeNode;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import static Niuke.MergesortTEST.generateRandomArray;
import static utils.Utils.*;

public class Test {



    public static void main(String[] args) {
        Book a = new Book("aaa",5);
        Book b = new Book("bbb",1);
//        Set<Book> set = new HashSet<>();
//        HashMap<Book, Integer> map = new HashMap<>();
//        map.put(a, 1);
//        map.put(b, 2);
//        Executors.newFixedThreadPool(1);
//        Executors.newSingleThreadExecutor();
//        Executors.newCachedThreadPool();
//        for (Book book : set) {
//            System.out.println(book.name + " " + book.value);
//        }

        ThreadLocal threadLocal = new ThreadLocal();

        String za = "大萨达";
        System.out.println(za.length());

    }
}

class Book{
    String name;
    int value;

    public Book(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return value == book.value &&
                Objects.equals(name, book.name);
    }

//    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
