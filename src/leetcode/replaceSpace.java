package leetcode;

public class replaceSpace {
    public static String replaceSpace(StringBuffer str) {
        int numberOfSpace = 0;
        int stringLength = str.length();
        int newlength = str.length();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                numberOfSpace++;
            }
        }
        newlength += numberOfSpace * 2;
        for (int i = 0; i < newlength - stringLength; i++) {
            str.append("_");
        }
        int p1 = stringLength;
        int p2 = newlength;
//        while( p2 >= 0){
////            if ()
//        }
        str.insert(stringLength+2, "a");
        System.out.println(str);
        return null;
    }

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("Hello world And You");
        replaceSpace(s);
    }
}