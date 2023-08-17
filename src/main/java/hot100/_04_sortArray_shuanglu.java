package hot100;

import java.util.Random;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-14-23:01
 * @Desc:排序数组
 */


public class _04_sortArray_shuanglu {

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

        int randonIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randonIndex);
        int pivot = nums[left];

        int le = left + 1; // less equals
        int ge = right;  // greater equakls
//        all in nums[left+1...le)<=pivot
//        all in nums(ge..right]>=pivot
        while (true) {
            while (le <= ge && nums[le] < pivot ) {
                le++;
            }
            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }
//            le来到第一个大于等于pivot的位置
//            ge来到第一个小于等于pivot的位置
            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }

        swap(nums, left, ge);

        return ge;

    }


    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {111, 2, 23, 4, 25, 63, 7, 8, 9, 10, 11, 34, 13, 14};
        int[] ints = new _04_sortArray_shuanglu().sortArray(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(nums[i]);
        }


    }

}



