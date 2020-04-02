package leetcode;

import Test.Student;
import utils.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Print1ToMaxOfDiagits {
    public static void solution1(int n) {
        if (n < 0){
            return;
        }
        char[] number = new char[n];
        help(number, 0);
    }

    public static void help(char[] number, int digit){
        if (digit == number.length){
            printnumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char)(i + '0');
            help(number, digit + 1);
        }
    }

    public static void printnumber(char[] number){
        int index = 0;
        while(index < number.length && number[index] == '0'){
            index++;
        }
        while(index < number.length){
            System.out.print(number[index++]);
        }
        System.out.println();
    }
    private static int size;
    public static void test(){
        System.out.println(size);
    }
    public static void main(String[] args) {
        System.out.println(Student.class.getComponentType());
//        Array.newInstance(Student.class.getComponentType());
    }

}