package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
class convert {
    public static String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            rows.add(new StringBuilder());
        }
        int flag = 1;
        int i = 0;
        for(char c : s.toCharArray()){
            rows.get(i).append(c);
            i = i + flag;
            if(i == numRows - 1 || i == 0) flag *= -1;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows){
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String leetcodeishiring = convert("AB", 1);
        System.out.println(leetcodeishiring);
    }
}