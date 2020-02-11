package leetcode;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class minNumberInRotateArray {
    public static int minNumberInRotateArray(int [] array) {
        if (array.length < 1){
            return 0;
        }
        int L = 0;
        int R = array.length - 1;
        int midindex = L;
        while(array[L] >= array[R]){
            midindex = (L + R) >> 1;
            if (array[L] == array[R] && array[L] == array[midindex]){
                return findminnumber(array);
            }
            if (R - L == 1){
                midindex = R;
                break;
            }
            if (array[midindex] > array[L]){
                L = midindex;
            } else if(array[midindex] < array[R]){
                R = midindex;
            }
        }

        return array[midindex];
    }

    public static int findminnumber(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,5,5,5,5,5,1,2,3,4};
        int result = minNumberInRotateArray(arr);
        System.out.println(result);
    }
}