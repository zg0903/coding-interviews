package leetcode;

import sun.security.util.Length;

import java.util.Arrays;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-11-20-22:23
 * @Desc:给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
 */
public class _27_removeElement {


        public int removeElement(int[] nums, int val) {
            int n = nums.length;
            int left = 0;
            for (int right = 0; right < n; right++) {
                if (nums[right] != val) {
                    nums[left] = nums[right];
                    left++;
                }
            }
            return left;
        }


    public int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;


    }

    public static void main(String[] args) {
        _27_removeElement removeElement = new _27_removeElement();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int i = removeElement.removeElement(nums, 2);
        System.out.println("-----------------");
        System.out.println(i);

    }
}

