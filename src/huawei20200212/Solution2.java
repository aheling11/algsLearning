package huawei20200212;

import java.util.Scanner;

/**
 * 题目描述，给定一个大小为N的数组A，在此数组进行M个操作，操作分为更新和求和
 * 1.更新：给定整数a，b，k(0<=a<=b<=N-1,1<=k<=4)，依次对数组A区间[a,b](包含索引a，b)中的每个元素e更新为e的k次方，由于e的k次方会非常大（超过64位数），
 * 所以将其取模G=1234567891，即e的k次方%G
 * 2.求和：给定整数a，b(0<=a<=b<=N-1,1<=k<=4)，计算数组A区间[a,b](包含索引a，b)的元素总和
 *
 */

public class Solution2 {

    public static void Mhandlearr(){
        int G = 1234567891;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        while (sc.hasNext()){
            String a = sc.nextLine();
            System.out.println(a);
        }
        int k = 4;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < k; j++) {

            }
        }

    }

    public static void main(String[] args) {

        Mhandlearr();

    }

}
