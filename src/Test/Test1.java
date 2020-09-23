package Test;


import utils.Utils;

import java.util.*;

import static Niuke.MergesortTEST.generateRandomArray;
import static utils.Utils.*;


public class Test1 {


    public static void rightmethod(Integer a ) {
        String s = new String("2");
        s.intern();
        String s2 = "2";
        System.out.println(s == s2);


        String s3 = new String("3") + new String("3");
        s3.intern();
        String s4 = "33";
        System.out.println(s3 == s4);


    }
    // for test
    public static void main(String[] args) {
        Test1 a = new Test1();
        
//        System.out.println(a);

    }



}
