package hot100;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-13-19:09
 * @Desc:
 */
public class _3_findKthLargest {

//    快排

    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    public void qucikSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] > nums[left]) j--;
            while (i < j && nums[i] <= nums[left]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, left);
        qucikSort(nums,left,i-1);
        qucikSort(nums,i+1,right);

    }


    private int quickSort2(int[] nums, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        if (i > nums.length - k) return quickSort2(nums, k, l, i - 1);
        if (i < nums.length - k) return quickSort2(nums, k, i + 1, r);
        // 若基准数索引为 n - k ，则直接返回该元素
        return nums[nums.length - k];
    }


    public int findKthLargest(int[] nums, int k) {
        qucikSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];

    }
    public int findKthLargest2(int[] nums, int k) {
        return quickSort2(nums, k, 0, nums.length - 1);

    }




}
