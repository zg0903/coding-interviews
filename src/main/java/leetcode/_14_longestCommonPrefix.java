package leetcode;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-10-23-21:19
 * @Desc:
 */
public class _14_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;

    }

    public String longestCommonPrefix2(String[] strs) {
        int min = strs[0].length();
        int index = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
                index = i;
            }
        }
        String str = strs[index];
        for (int i = 0; i < strs.length; i++) {
            String demo = strs[i].substring(0, min);
            while (!demo.equals(str) && min != 0) {
                str = str.substring(0, --min);
                demo = demo.substring(0, min);
            }
        }
        return str;
    }


    public String longestCommonPrefix(String str1, String str2) {
        int count = Math.max(str1.length(), str2.length());
        int begin = 0;
        while (begin < count && str1.charAt(begin) == str2.charAt(begin)) {
            begin++;
        }
        return str1.substring(0, begin);

    }
}
