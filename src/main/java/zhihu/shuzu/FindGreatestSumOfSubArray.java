package zhihu.shuzu;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name zhihu.shuzu
 * @date 2022-03-05-15:49
 * @Desc:连续子数组的最大和
 */


public class FindGreatestSumOfSubArray {


    public int findGreatestSumOfSubArray(int[] array) {
        if (array.length == 0 || array == null)
            return 0;

        int maxSum = array[0];
        int curSum = array[0];

        for (int i = 0; i < array.length - 1; i++) {
            if (curSum < 0) {
                curSum = array[i];
            } else curSum += array[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }

        }
        return maxSum;

    }


    public int FindGreatestSumOfSubArray2(int[] array) {
        if (array == null || array.length == 0) return 0;

        int maxSum = array[0];
        int curSum = array[0];
        for (int i = 1; i < array.length; i++) {
            // if (curSum + array[i] < array[i]),也就是if (curSum < 0) 则curSum的结果是array[i]
            // 否则curSum的值是curSum + array[i]
            curSum = Math.max(curSum + array[i], array[i]);
            // 如果curSum > maxSum,则maxSum取curSum，否则maxSum = maxSum
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }


}
