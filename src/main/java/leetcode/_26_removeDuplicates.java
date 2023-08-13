package leetcode;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-11-20-21:01
 * @Desc: 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 */
public class _26_removeDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }


    //    by self
    public int removeDuplicates1(int[] nums) {

        int slow = 0;
        int quick = 1;
        int count = 0;
        while (quick <= nums.length - 1 && slow < quick) {
            while (quick <= nums.length - 1 && nums[slow] == nums[quick]) {
                quick++;
            }
            if (quick <= nums.length - 1) {

                nums[slow + 1] = nums[quick];
                count++;
            }
            slow++;
            quick++;

        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }

        return count + 1;
    }

    public static void main(String[] args) {
        _26_removeDuplicates removeDuplicates = new _26_removeDuplicates();
        int[] nums = {-1, 0, 0, 0, 0, 3, 3};
        int i = removeDuplicates.removeDuplicates(nums);
        System.out.println("-----");
        System.out.println(i);
    }

}
