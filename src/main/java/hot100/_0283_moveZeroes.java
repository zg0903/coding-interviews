package hot100;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-27-14:48
 * @Desc:移动零 快慢指针 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */


public class _0283_moveZeroes {


    public void moveZeroes(int[] nums) {

        int len = nums.length;
        int slow = 0;
        int fast = 0;
        while (fast < len) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;


        }
    }
}
