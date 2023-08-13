package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-10-29-19:48
 * @Desc:
 */
public class _18_fourSum {


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();

        long target1 = (long) target;
        if (nums == null || nums.length < 4) {
            return resultList;
        }


        Arrays.sort(nums);
        int length = nums.length;

        HashSet<List<Integer>> hashSet = new HashSet<>();

        for (int i = 0; i < length; i++) {
//            if (nums[i] > target) {
//                break;
//            }

            if (i > 1 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    long sum = (long) ((long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right]);
                    if (sum == target1) {
                        hashSet.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
//                        resultList.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                    }
                    if (sum < target1) {
                        left++;
                    } else {
                        right--;
                    }
                }


            }


        }
        hashSet.forEach(r -> resultList.add(r));

        return resultList;
    }


    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }


    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int[] nums = {0};
//        -5,-4,-3,1
//        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int[] nums = {-493, -470, -464, -453, -451, -446, -445, -407, -406, -393, -328, -312, -307, -303, -259, -253, -252, -243, -221, -193, -126, -126, -122, -117, -106, -105, -101, -71, -20, -12, 3, 4, 20, 20, 54, 84, 98, 111, 148, 149, 152, 171, 175, 176, 211, 218, 227, 331, 352, 389, 410, 420, 448, 485};
//        int[] nums = {-221,410,420,448};
        int target = 1057;
//        int target = -294967296;
//        int target = 0;
        List<List<Integer>> lists = _18_fourSum.fourSum2(nums, target);
        System.out.println(lists);
//        System.out.println(nums.length);
//        System.out.println(nums[6]);

//[[-221,410,420,448],[-12,211,410,448],[3,149,420,485],[4,148,420,485],[54,98,420,485],[84,211,352,410],[98,218,331,410],[98,218,352,389],[171,211,227,448]]
    }
}
