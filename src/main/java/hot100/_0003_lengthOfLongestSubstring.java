package hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-27-16:55
 * @Desc:无重复字符的最长子串
 */
public class _0003_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0, len = s.length();
        for(int j = 0; j < len; j++) {
            if (dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }



}
