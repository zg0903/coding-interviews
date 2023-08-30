package hot100;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-27-14:48
 * @Desc:移动零 快慢指针
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
