package hot100;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-19-17:55
 * @Desc:
 */
public class _10_searchRange {

    public int[] searchRange(int[] nums, int target) {

        int first = -1;
        int last = -1;
        int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                first = mid;
//                缩小范围继续查找  找第一个等于target的位置
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid  = (left + right) / 2;
            if (target == nums[mid]) {
                last = mid;
//                缩小范围继续查找  找最后一个等于target的位置
                left = mid + 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }


        }

        return new int[]{first, last};

    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8};
        int[] ints = new _10_searchRange().searchRange(nums, 8);
        System.out.println(Arrays.toString(ints));
    }
}
