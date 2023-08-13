package leetcode;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-10-22-23:15
 * @Desc:给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 */
public class _08_reverse {

    public static int reverse(int num) {
        int res = 0;
        while (num != 0) {
            int tmp = num % 10;
            if (res > 214748364) return 0;
            if (res < -214748364) return 0;

            res = res * 10 + tmp;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int reverse = _08_reverse.reverse(214748364);
        System.out.println(reverse);
    }
}
