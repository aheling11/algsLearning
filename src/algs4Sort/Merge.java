package algs4Sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Merge {


    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sortProcess(a, 0, a.length-1);

    }

    private static void sortProcess(Comparable[] a, int l, int r) {
        if (l >= r) return;
        int mid = l + ((r - l) >> 1);
        sortProcess(a, l, mid);
        sortProcess(a, mid+1, r);
        merge(a, l, mid, r);
    }

    private static void merge(Comparable[] a, int l, int mid, int r) {
        int p = 0;
        int p1 = l;
        int p2 = mid + 1;
        while( p1 <= mid && p2 <= r) {
            aux[p++] = less(a[p1], a[p2]) ? a[p1++] : a[p2++];
        }

        while(p1 <= mid) {
            aux[p++] = a[p1++];
        }
        while(p2 <= r) {
            aux[p++] = a[p2++];
        }

        for (int i = 0; i < r - l + 1; i++) {
            a[l + i] = aux[i];
        }

    }


    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0; }

    private static void exch(Comparable[] a, int i, int j)
    { Comparable t = a[i]; a[i] = a[j]; a[j] = t; }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        //测试数组是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args) {
        // 从标准输入读取字符串，将它们排序并输出
//        String[] a = StdIn.readAllStrings();
        Integer[] a = new Integer[]{2,3,1,6,4,7,9};
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
