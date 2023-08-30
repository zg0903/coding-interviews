package hot100;

import java.util.HashMap;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-27-17:55
 * @Desc:最小覆盖子串
 */
public class _0076_minWindow {
    public String minWindow(String source, String target) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();

        // needs是需要的字符和数量，window记录窗口中有效的字符和数量
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        // valid 变量表示窗口中满足 need 条件的字符个数
        int valid = 0;
        int left = 0, right = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;

        for (char c : t) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s.length) {
            // c 是将移入窗口的字符
            char c = s[right];
            // 扩大窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                // ⭐注意：两个Integer类型的数据不能直接用< == >判断
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == needs.size()) {
                // 在这里更新最小覆盖子串(更新最终结果)
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移要出窗口的字符
                char d = s[left];
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (needs.containsKey(d)) {
                    window.put(d, window.get(d) - 1);
                    // window窗口内的数据无法满足，不再有效
                    // ⭐注意：两个Integer类型的数据不能直接用< == >判断
                    if (window.get(d) < Integer.valueOf(needs.get(d))) {
                        valid--;
                    }
                }
            }
        }

        // 返回最小覆盖子串(使用三目运算使代码简洁)
        return len == Integer.MAX_VALUE ? "" : source.substring(start, start + len);
    }


}
