package hot100;

import java.util.Random;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-14-23:01
 * @Desc:排序数组
 */


public class _04_sortArray {

    //    随机
    private final static Random random = new Random(System.currentTimeMillis());

    //快速排序 第一版

    public int[] sortArray(int[] nums) {
        quikSort(nums, 0, nums.length - 1);
        return nums;
    }

    //    递归
    private void quikSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        //分区  划分
        int pivotIndex = partion(nums, left, right);
        quikSort(nums, left, pivotIndex - 1);
        quikSort(nums, pivotIndex + 1, right);
    }

    private int partion(int[] nums, int left, int right) {
//         [0..right-left]
//        left-right
        int randonIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randonIndex);
        int pivot = nums[left];
        int j = left;
//        int j = left+1;

//        第一个区间小于 pivot  all in nums[left+1, j] <= pivot  初始化空区间
//         all in nums(j,i)> pivot
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                j++;
                swap(nums, i, j);

//                swap(nums, i, j); //j = left+1
//                j++;     //j = left+1
            }
        }
        swap(nums, left, j);
//        swap(nums, left, j-1);  //j = left+1
        return j;
//        return j-1; //j = left+1
    }


    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {111, 2, 23, 4, 25, 63, 7, 8, 9, 10, 11, 34, 13, 14};
        int[] ints = new _04_sortArray().sortArray(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(nums[i]);
        }


    }

}



