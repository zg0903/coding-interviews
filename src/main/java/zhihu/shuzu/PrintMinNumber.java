package zhihu.shuzu;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name zhihu.shuzu
 * @date 2022-03-06-12:57
 * @Desc:把数组排成最小的数
 */



import java.util.ArrayList;
import java.util.List;

public class PrintMinNumber {
    public String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";

        List<Integer> list = new ArrayList<>();
        for (int a : numbers) {
            list.add(a);
        }
        // 这句是核心，即比较ab和ba的大小，小的排在前面
        list.sort((a, b) -> (a + "" + b).compareTo(b + "" + a));
        StringBuilder sb = new StringBuilder();
        for (int a : list) {
            sb.append(a);
        }
        return sb.toString();
    }
}
