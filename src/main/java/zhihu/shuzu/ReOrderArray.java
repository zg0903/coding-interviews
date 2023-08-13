package zhihu.shuzu;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name zhihu.shuzu
 * @date 2022-03-05-14:29
 * @Desc:调整数组的顺序使奇数位于偶数前面
 */


public class ReOrderArray {


    public void reOrderArray(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return;
        }

        int[] temp = new int[arr.length];
        int p = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (isOdd(arr[i])) {
                temp[p++] = arr[i];
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (!isOdd(arr[i])) {
                temp[p++] = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }


    }


    private boolean isOdd(int val) {
        return (val & 1) == 1;
    }

}
