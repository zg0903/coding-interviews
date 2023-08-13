package zhihu.zifuchuang;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name zhihu.zifuchuang
 * @date 2022-03-02-20:44
 * @Desc:反转字符串
 */
public class ReverseWords {

    //    输入一个英文句子，翻转句子中单词的顺序，但单词内的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入"I am a student."则输出"student. a am I"
    public static String ReverseSentence(String str) {
        if (str == null || str.trim().equals("")) return str;
        String[] word = str.split("\\s+");
        for (int i = 0; i < word.length; i++) {
            System.out.println(word[i]);
        }
        StringBuilder s = new StringBuilder();
        for (int i = word.length - 1; i > 0; i--) {
            s.append(word[i]);
        }
        return s.toString();

    }


    //字符串的左旋操作是把字符串前面的若干个字符转移到字符串的尾部。
//比如输入字符串"abcdefg"和一个数字2，则左旋转后得到字符串"cdefgab"
    public String leftRotateString(String str, int n) {
        if (str == null || n < 0 || n < str.length()) return null;
        StringBuilder s = new StringBuilder(str);
        s.append(s.substring(0, n));
        return s.substring(n, s.length());

    }

    //    三次反转：索引n将字符串分成两个子字符串，分别反转这两个子字符串，然后反转整个字符串。
    public String leftRotateString2(String str, int n) {
        if (str == null || n < 0 || n > str.length()) return "";
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, str.length() - 1);
        reverse(chars, 0, str.length() - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int low, int high) {
        while (low < high) {
            char c = chars[high];
            chars[high] = chars[low];
            chars[low] = c;
            low++;
            high--;
        }
    }


    public static void main(String[] args) {
        System.out.println(ReverseSentence("I am a student."));
    }


}
