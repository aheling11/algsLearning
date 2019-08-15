package algs4Sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Shell {

    public static void sort(Comparable[] a ) {
        int n = a.length;
        int h = 1;
        while (h < n/3) h = 3*h + 1;

        while( h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j-=h)
                    exch(a, j, j-h);

            }

            h /= 3;
        }
        assert isSorted(a);
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
        Integer[] a = new Integer[]{3,6,1,2,5,4,9,8};
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
