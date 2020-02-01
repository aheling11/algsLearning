package leetcode;

/**
 * 777. 在LR字符串中交换相邻字符
 */
class canTransform {
    public static boolean canTransform(String start, String end) {
        char[] sarr = start.toCharArray();
        char[] earr = end.toCharArray();
        int i = 0;
        int j = 0;
        int n = sarr.length;

        while(i < n && j < n){
            while(i < n && sarr[i] == 'X'){
                i++;
            }
            while(j < n && earr[j] == 'X'){
                j++;
            }
            if((i < n) ^ (j < n)) return false;

            if( i < n && j < n){
                if(sarr[i] != earr[j]){
                    return false;
                }
                if(sarr[i] == 'R' && i > j){
                    return false;
                }
                if(sarr[i] == 'L' && i < j){
                    return false;
                }
            }

            i++;
            j++;
        }
        return true;
    }




    public static void main(String[] args) {
        //start = "RXXLRXRXL", end = "XRLXXRRLX"
        String start = "RXXLRXRXL";
        String end   = "XRLXXRRLX";
        boolean a = false;
        boolean b = false;
        System.out.println(a ^ b);
//        System.out.println(canTransform(start, end));
    }
}