package Niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class formatsconvert {

    public static void main(String[] args) throws Exception{
        String string = "",table = "0123456789ABCDEFG";
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] st = bf.readLine().split(" ");
        long M = Integer.parseInt(st[0]); // 十进制数M
        int N=Integer.parseInt(st[1]); // 转为 N 进制数

        int flag = 0;
        if ( M < 0 ){
            M = -1 * M;
            flag = 1;
        }

        while (M > N) {
            int temp = (int)M%N;
            string = table.charAt((int)M%N)+string;
            M = M/N;
        }

        string = table.charAt((int)M)+string;
        if (flag == 1) {
            string = "-"+string;
        }
        System.out.println(string);

    }
}
