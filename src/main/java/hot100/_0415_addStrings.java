package hot100;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-27-15:16
 * @Desc:字符串相加 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 */
public class _0415_addStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {

            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tem = n1 + n2 + carry;
            carry = tem / 10;
            res.append(tem % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();


    }
}
