package ToOffer;

import java.util.ArrayList;

class findContinuousSequence {
    public static int[][] findContinuousSequence(int target) {
        ArrayList<int[]> list = new ArrayList<>();
        int i = 1;
        int j = 1;
        int s = 0;
        while(i <= target / 2){
            if(s < target){
                s += j;
                j++;
            } else if(s > target){
                s -= i;
                i++;
            } else {
                int[] arr = new int[j - i];
                int index = 0;
                for(int k = i; k < j; k++){
                    arr[index++] = k;
                }
                list.add(arr);
                s -= i;
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] continuousSequence = findContinuousSequence(9);
        for(int[] arr : continuousSequence){
            for(int num : arr){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}