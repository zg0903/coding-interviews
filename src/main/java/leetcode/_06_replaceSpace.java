package leetcode;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-10-20-23:24
 * @Desc:
 */
public class _06_replaceSpace {

    public static String replaceSpace(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                stringBuffer.append(("%20"));
            } else stringBuffer.append(s.charAt(i));
        }
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String rstr = _06_replaceSpace.replaceSpace("We d dasf d ");

    }
}
