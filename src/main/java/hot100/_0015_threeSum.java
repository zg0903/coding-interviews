package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-21-22:17
 * @Desc:三数之和
 */
public class _0015_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Arrays.sort(nums);


        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }


            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            if (nums[k] + nums[k + 1] + nums[k + 2] > 0) break;
             while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ; //左指针前进并去重
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    res.add(new ArrayList<Integer>((Arrays.asList(nums[k], nums[i], nums[j]))));
                    while (i < j && nums[i] == nums[++i]) ;//左指针前进并去重
                    while (i < j && nums[j] == nums[--j]) ;//右指针后退并去重
                }
            }
        }

        return res;
    }
}
