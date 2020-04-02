package ToOffer;

public class binarySearch {


    public static int binarySearch(int[] nums, int target){
        int L = 0;
        int R = nums.length - 1;
        while (L <= R){
            int mid = L +(R - L) >> 1;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                R = mid - 1;
            } else if (nums[mid] < target){
                L = mid + 1;
            }
        }
        return -1;
    }

    public static int serachLeft(int[] nums, int target){
        int L = 0;
        int R = nums.length - 1;
        while (L <= R){
            int mid = L + ((R - L) >> 1);
            if (nums[mid] == target){
                R = mid - 1;
            } else if (nums[mid] < target){
                L = mid + 1;
            } else  if(nums[mid] > target){
                R = mid - 1;
            }
        }
        if (L >= nums.length || nums[L] != target){
            return -1;
        }
        return L;
    }

    public static int serachRight(int[] nums, int target){
        int L = 0;
        int R = nums.length - 1;
        while (L <= R){
            int mid = L + ((R - L) >> 1);
            if (nums[mid] == target){
                L = mid + 1;
            } else if (nums[mid] < target){
                L = mid + 1;
            } else  if(nums[mid] > target){
                R = mid - 1;
            }
        }
        if (R < 0 || nums[R] != target){
            return -1;
        }
        return R;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,2,3,6};
        int i = serachLeft(nums, 7);
        System.out.println(i);
    }
}
