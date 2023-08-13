package zhihu.shuzu;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name zhihu.shuzu
 * @date 2022-03-05-15:07
 * @Desc:数组中出现次数超过一半的数字
 */


public class MoreThanHalf {


    public int findNumMoreThanHalf(int[] array) {
        if (array == null || array.length == 0) return 0;

        int count = 1;
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                result = array[i];
                count = 1;
            } else if (array[i] == result) count++;
            else count--;
        }
        return checkMoreThanHalf(array, result);
    }


    private int checkMoreThanHalf(int[] array, int number) {
        int count = 0;
        for (int a : array) {
            if (a == number) count++;
        }

        return count > array.length / 2 ? number : 0;
    }

}
