package leetcode;// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class Main {

    public static void Q1(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }
        int cnt = 0;

        for (String word : words) {
            System.out.println(word);
        }
    }
    public static int Q4(){
        Scanner sc = new Scanner(System.in);
        String X = sc.nextLine();
        String Y = sc.nextLine();
        int[][]c = new int[X.length()+1][Y.length()+1];
        int maxlen = 0;
        int maxindex = 0;
        for(int i =1;i<=X.length();i++){
            for(int j=1;j<=Y.length();j++){
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    c[i][j] = c[i-1][j-1]+1;
                    if(c[i][j] > maxlen)
                    {
                        maxlen = c[i][j];
                        maxindex = i + 1 - maxlen;
                    }
                }
            }
        }
        System.out.println(maxlen);
        return maxlen;

    }

    public static void main(String[] args) {
        Q4();

    }
}