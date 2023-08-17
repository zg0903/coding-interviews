package hot100;

import java.util.Random;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-14-23:01
 * @Desc:排序数组
 */


public class _04_sortArrayEx1 {


    public int[] quickSortEx(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int piv = partion(nums, left, right);
        quickSort(nums, left, piv - 1);
        quickSort(nums, piv + 1, right);
    }

    private int partion(int nums[], int left, int right) {

        int piv = nums[left];
        int j = left;
        for (int i = j+1; i <= right; i++) {
            if (nums[i] <= piv) {
                j++;
                swap(nums, i, j);
            }

        }
        swap(nums, left, j);
        return j;
    }


    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {111, 2, 23, 4, 25, 63, 7, 8, 9, 10, 11, 34, 13, 14};
        int[] ints = new _04_sortArrayEx1().quickSortEx(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(nums[i]);
        }


    }

}



