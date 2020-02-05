# 常见题

## 1. 寻找第K大的值

### 问题描述

> 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
>
> 示例 1:
>
> 输入: [3,2,1,5,6,4] 和 k = 2
> 输出: 5
> 示例 2:
>
> 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
> 输出: 4
> 说明:
>
> 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
>
> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array

### 问题分析

这道题有几种做法

1. 对数组进行排序，直接选出第k大的数字，这样做的时间复杂度是O(nlogn)，也就是排序的时间复杂度。
2. 利用快速排序中partition的思想，对数组进行partition操作，即随机选择一个数x，比这个数小的数放在这个数左边，假设这部分为Sa，比这个数大的放在右边，假设这部分为Sb，如果Sb中的数个数为k-1，即比x大的数的个数k-1个，那么选择出来的这个数肯定是第k大的数。平均复杂度为O(n)。
3. 使用一个大小为k的最小堆来存储最大的k个数字，接下来每次从输入的n个数中读入一个数。如果最小堆中的数字少于k个，则直接把这次读入的数放入最小堆之中，如果最小堆中已有k个数字了，也就是最小堆已满，此时我们将这个要输入的数和最小堆根节点的数进行比较，如果这个数比根节点的值还要小则不需要加进来，如果这个数比根节点的值大则将其插入堆中，替换掉一个节点的值。时间复杂度为O(nlogn)

对比：

第二种方法会修改原来的数组，而且不是很适合处理海量数据。因为一旦数组大小n很大，内存可能放不下整个数组。这个时候就可以使用第三种方法，这种方法尽管速度比第二种慢，但是更适合处理海量数据，即n很大，k较小的情况，每次读取一个数字时，判断是不是需要将其放入最小堆中就行，所以内存能放下大小为k的最小堆即可。

### Solution

1. 基于partition的方法

```java
public static int findKnumber(int[] nums, int k){
    int R = nums.length - 1;
    int L = 0;
    int index = partition(nums, 0, R);
    int length = nums.length - index;
    while(length != k){
        // 如果index右边的数小于k，则在index左边继续找
        if (length < k){ 
            R = index - 1;
            index = partition(nums, L, R); //每次更新
        }
        // 如果index右边的数大于k，则在index右边继续找
        else{
            L = index + 1;
            index = partition(nums, L, R);
        }
        length = nums.length - index;
    }
    return nums[index];
}

//就是快排里的partition操作
public static int partition(int[] arr, int L, int R){
    swap(arr, R, L + (int)(Math.random()*(R - L + 1)));
    int less = L - 1;
    int more = R;
    int cur = L;
    while(cur < more){
        if (arr[cur] < arr[R]){
            swap(arr, cur++, ++less);
        } else if(arr[cur] > arr[R]){
            swap(arr, cur, --more);
        } else {
            cur++;
        }
    }
    swap(arr, cur, R);
    return more;
}

public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
```

2. 基于堆的方法

   