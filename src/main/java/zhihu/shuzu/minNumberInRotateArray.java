package zhihu.shuzu;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name zhihu.shuzu
 * @date 2022-03-05-14:08
 * @Desc:旋转数组中的最小数字
 */

public class minNumberInRotateArray {

    public int minNumberInRotateArray01(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i - 1]) {
                return array[i + 1];
            }
        }
        return array[0];

    }


    public int minNumberInRotateArray02(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int midle = (left + right) / 2;
            if (array[midle] > array[right]) {
                left = midle + 1;
            } else if (array[midle] < array[right]) {
                right = midle;
            } else {
                right--;
            }

        }
        return array[left];


    }


}
