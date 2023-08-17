package hot100;

import java.util.Random;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-14-23:01
 * @Desc:排序数组
 * 版本 1：基本快排：把等于切分元素的所有元素分到了数组的同一侧，可能会造成递归树倾斜；
 * 版本 2：双指针快排：把等于切分元素的所有元素 等概率 地分到了数组的两侧，避免了递归树倾斜，递归树相对平衡；
 * 版本 3：三指针快排：把等于切分元素的所有元素挤到了数组的中间，在有很多元素和切分元素相等的情况下，递归区间大大减少。
 */


public class _04_sortArray_sanlu {

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


        int randonIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randonIndex);
        int pivot = nums[left];

        int lt = left + 1; // less equals
        int gt = right;  // greater equakls
        //   all in nums[left+1...lt)<pivot
        //   all in nums[lt...i)=pivot
        //   all in nums(gt..right]>pivot
        int i = left + 1;

        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, i, lt);
                lt++;
                i++;
            } else if (nums[i] == pivot) {
                i++;
            } else {
                swap(nums, i, gt);
                gt--;
            }
        }

        swap(nums, left, lt - 1);


        quikSort(nums, left, lt - 2);
        quikSort(nums, gt + 1, right);
    }


    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {111, 2, 23, 4, 25, 63, 7, 8, 9, 10, 11, 34, 13, 14};
        int[] ints = new _04_sortArray_sanlu().sortArray(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(nums[i]);
        }


    }

}



