package hot100;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-15-23:26
 * @Desc: 归并排序
 */
public class _04_merge_guibin {

    public int[] sortArray(int[] nums) {
        int length = nums.length;
        int[] temp = new int[length];
        mergeSort(nums, 0, length - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        // 2、形成的区间长度为 1 ：left = right，此时没有必要去"分"，也无法"分"
        if (left == right) {
            // 只有一个元素的时候，无需任何操作
            return;
        }
        // 使用一分为二的思路，一直递归下去
        // int mid = (left + right) / 2; 这种写法在 left 和 right 是大整数的时候，会发生溢出
        int mid = left + (right - left) / 2;

        // 下面这几行代码关于边界值的处理要特别小心，要紧扣自己定义的变量的含义进行逻辑的编写
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        mergeTwoSortedArray(nums, left, mid, right);

    }


    private void mergeTwoSortedArray(int[] arr, int left, int mid, int right) {
        // 首先计算出这个数组的长度
        // 因为是左边闭区间，右边闭区间，所以元素的个数就是：右边界 - 左边界 + 1
        int length = right - left + 1;
        // 新建一个数组，赋值，用于比较
        // 这里每进行一次比较，都要 new 一个数组，开销很大
        int[] temp = new int[length];
        // 为新数组赋值
        for (int i = 0; i < length; i++) {
            temp[i] = arr[left + i];
        }
        // 左边数组的起始位置
        int l = 0;
        // 右边数组的起始位置
        int r = mid - left + 1;

        // 循环遍历把 arr 在 [left..right] 这个区间重新赋值
        // temp 数组中的元素不动，只是拿来做比较，然后我们一直修改的是 arr 数组在 [left..right] 的值
        for (int i = 0; i < length; i++) {
            // 先考虑如果左边数组用完（越界）的情况
            if (l > mid - left) {
                // 此时 l 遍历完成，就去拼命遍历 r 就好了
                arr[i + left] = temp[r];
                r++;
            } else if (r > length - 1) {
                // 此时 r 遍历完成，就去拼命遍历 l 就好了
                arr[i + left] = temp[l];
                l++;
            } else if (temp[l] <= temp[r]) {
                arr[i + left] = temp[l];
                l++;
            } else {
                arr[i + left] = temp[r];
                r++;
            }
        }
    }


    public static void main(String[] args) {

        int[] nums = {111, 2, 23, 4, 25, 63, 7, 8, 9, 10, 11, 34, 13, 14};
        int[] ints = new _04_merge_guibin().sortArray(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(nums[i]);
        }


    }

}
