package zhihu.shuzu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name main.java.zhihu
 * @date 2022-02-26-15:04
 * @Desc:
 */
public class duplicate2 {

    public static boolean Method1(int[] numbers, ArrayList duplica) {
        if (numbers == null) {
            return false;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                duplica.add(numbers[i]);
            }
        }
        System.out.println(duplica);
        return false;
    }


    public static boolean Method2(int[] numbers, int length, ArrayList duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                // 现在numbers[i] != i ，设numbers[i] = j,所以如果下面的if成立,就是numbers[i] == numbers[j],说明找到 重复
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication.add(numbers[i]);
                    System.out.println(duplication);
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    // 交换numbers[i]和numbers[numbers[i]]
    private static void swap(int[] numbers, int p, int q) {
        int temp = numbers[p];
        numbers[p] = numbers[q];
        numbers[q] = temp;
    }


    public static void main(String[] args) {
        int[] numbers = {
                2, 3, 1, 0, 2, 5, 3
        };

        ArrayList duplica = new ArrayList();
//        duplicate2.Method1(numbers, duplica);
        duplicate2.Method2(numbers, 7, duplica);
    }


}
