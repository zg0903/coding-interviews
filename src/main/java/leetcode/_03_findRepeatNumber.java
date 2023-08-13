package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-10-20-22:15
 * @Desc:
 */
public class _03_findRepeatNumber {

//    时间复杂度 O(N)O(N)O(N) ： 遍历数组使用 O(N)O(N)O(N) ，HashSet 添加与查找元素皆为 O(1)O(1)O(1) 。
//空间复杂度 O(N)O(N)O(N) ： HashSet 占用 O(N)O(N)O(N) 大小的额外空间。

    public static int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            boolean add = hashSet.add(nums[i]);
            if (!add) {
                return nums[i];
            }
        }

        return 0;
    }


    //    排序后下边不正确的就是重复值
    public static int findRepeatNumber_2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return nums[i];
            }
        }
        return -1;
    }

    //    交换 和2类似
    public static int findRepeatNumber_3(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i])
                return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] num = {2, 3, 1, 0, 4, 5, 4};
        int repeatNumber = _03_findRepeatNumber.findRepeatNumber_2(num);
        System.out.println(repeatNumber);
    }

}





