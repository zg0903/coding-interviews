package leetcode;

import java.util.ArrayList;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-10-22-16:21
 * @Desc:将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 */
public class _05_convert {
    public static String convert(String s, int numRows) {
        if (s == null) {
            return "";
        }
        if (numRows < 2) return s;

        ArrayList<StringBuilder> stringBuilders = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            stringBuilders.add(new StringBuilder());
        }

        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            stringBuilders.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder sb : stringBuilders) {
            stringBuilder.append(sb);
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        String str= "PAYPALISHIRING";
        String convert = _05_convert.convert(str, 3);
        System.out.println(convert);
    }
}
