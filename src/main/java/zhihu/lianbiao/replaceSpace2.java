package zhihu.lianbiao;

import java.util.Arrays;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name zhihu
 * @date 2022-02-27-11:30
 * @Desc:
 */
public class replaceSpace2 {

    //    替换空格
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        // 统计空格个数
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        // 原来字符串的末尾指针
        int oldP = str.length() - 1;
        // 设置新长度
        str.setLength(str.length() + 2 * spaceNum);
        // 新的字符串的末尾指针
        int newP = str.length() - 1;
        while (oldP >= 0 && newP > oldP) {
            if (str.charAt(oldP) == ' ') {
                str.setCharAt(newP--, '0');
                str.setCharAt(newP--, '2');
                str.setCharAt(newP--, '%');
            } else {
                str.setCharAt(newP--, str.charAt(oldP));
            }
            oldP--;
        }
        return str.toString();
    }

    //
    public static void MergeTwoSortedArray(Integer[] a, Integer[] b) {
        int len = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                len++;
            }
        }

        int pA = len - 1; //指向a数组不为空的最后一个元素末尾
        int pB = b.length - 1; //指向b数组不为空的最后一个元素末尾
        int k = len + b.length - 1;  //// 指向归并后数组不为空的最后一个元素末尾

        while (k >= 0) {
            // a数组取完了，取b数组中的
            if (pA < 0) {
                a[k--] = b[pB--];
                // b数组取完了，取a数组中的
            } else if (pB < 0) {
                a[k--] = a[pA--];
                // 否则谁的大取谁的值
            } else if (a[pA] > b[pB]) {
                a[k--] = a[pA--];
            } else {
                a[k--] = b[pB--];
            }

        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        Integer[] b = {1, 3, 5, 7, 9};
        // {2, 4, 6, 8, 10}
        for (int i = 0; i < 5; i++) {
            a[i] = 2 * i + 2;
        }

        MergeTwoSortedArray(a, b);
        System.out.println(Arrays.toString(a));
    }
}
