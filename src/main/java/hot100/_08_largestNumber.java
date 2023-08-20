package hot100;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-19-16:15
 * @Desc:最大数
 */
public class _08_largestNumber {

    public String largestNumber(int[] nums) {

        int n = nums.length;
        String[] numToStr = new String[n];
        for (int i = 0; i < n; i++) {
            numToStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numToStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if (("0").equals(numToStr[0])) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(numToStr[i]);
        }
        return sb.toString();

    }
}
