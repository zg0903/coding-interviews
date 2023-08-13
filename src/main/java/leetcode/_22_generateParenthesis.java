package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-11-08-22:35
 * @Desc:数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class _22_generateParenthesis {

    ArrayList arrList = new ArrayList<String>();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        helper("", 0, 0);
        return arrList;

    }

    private void helper(String cur, int left, int right) {
        if (left == n && right == n) {
            arrList.add(cur);
            return;
        }
        if (left > n || left < right) {
            return;
        }
        helper(cur + "(", left + 1, right);
        helper(cur + ")", left, right + 1);


    }


}
