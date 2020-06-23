package Test;


import utils.Utils;

import java.util.*;

import static utils.Utils.*;


public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.stream().forEach(m->{
            System.out.println(m);
            m = m - 2;
        });

    }


}
