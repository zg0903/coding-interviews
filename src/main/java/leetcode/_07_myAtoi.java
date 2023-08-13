package leetcode;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-10-22-23:55
 * @Desc:
 */
public class _07_myAtoi {
    public static int myAtoi(String s) {
        int res = 0;
        int i = 0;
        int flag = 1;  //控制正负
//        去除空格
        while (s.charAt(i) == ' ') {
            i++;
        }
        if (s.charAt(i) == '-') flag = -1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int r = s.charAt(i) - '0';
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && r > 7) {
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + r;
            i++;
        }
        return flag > 0 ? res : -res;

    }

    public static void main(String[] args) {
        String s = "   +41938888888 with words";
        int i = _07_myAtoi.myAtoi(s);
        System.out.println(i);
    }

}
