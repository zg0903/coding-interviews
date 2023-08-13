package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-10-28-22:01
 * @Desc: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 */
public class _17_letterCombinations {
    private String[] letterArray = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private ArrayList<String> resultList = new ArrayList<String>();


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return resultList;
        }
        dfs(new StringBuilder(), digits);
        return resultList;

    }

    private void dfs(StringBuilder path, String digits) {
        if (path.length() == digits.length()) {
            resultList.add(path.toString());
            return;
        }
        int currentPath = digits.charAt(path.length()) - '0';
        String currentLetter = letterArray[currentPath];
        for (char c : currentLetter.toCharArray()) {
            path.append(c);
            dfs(path, digits);
            path.deleteCharAt(path.length() - 1);

        }
    }


    public static void main(String[] args) {

        List<String> strings = new _17_letterCombinations().letterCombinations("2345");
        System.out.println(strings);
    }
}
