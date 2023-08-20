package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-17-23:06
 * @Desc:合并两个有序数组
 */
public class _07_mergeinterval {
    public int[][] merge1(int[][] intervals) {
        //思路：
        //1.先将二维数组每一行按第一列排序得到诸如 [ [0,2], [1,5], [6,8], [10,11] ]
        //2.循环遍历每一行,给结果数组添加数据,有以下添加情况
        //3.对于结果数组 merge 的第一行,直接 add 进去即先将 [0,2] 添加
        //4.对于 merge 的其他行,若无重叠也直接添加如 [6,8], [10,11]
        //5.若有重叠,则修改上一行如 [0,2], [1,5] -> [0,5]

        int n = intervals.length;

        //通过 sort 函数对二维数组每一行按第一列元素进行排序
        //重写比较器方法,o1[] - o2[] 表示当 o1 大于 o2 时,将 o1 放在 o2 后面,即基本的升序排序
        //而 o1[0] - o2[0] 表示按二维数组的每一行第一列元素排序,类似的 o[1] - o2[1]代表按第二列进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merge = new ArrayList<int[]>();

        for (int i = 0; i < n; i++) {

            //创建变量指向每行的左右元素(两列)
            int left = intervals[i][0];
            int right = intervals[i][1];

            //直接 add 的情况：当为第一行或者相邻两行无重叠时
            //解释：两行无重叠,即对应在 merge 中上一行的第 1 列小于本行第 0 列
            if (merge.size() == 0 || merge.get(merge.size() - 1)[1] < left) {
                merge.add(new int[]{left, right});
            }
            //合并的情况：当有重叠时,将 merge 中上一行的右边界更新
            else {
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], right);
            }
        }
        //可以学习下此种将 list 转二维数组的方法
        return merge.toArray(new int[merge.size()][]);
    }


    public int[][] merge2(int[][] intervals) {
        int m = intervals.length;
        //先按左边界排序
        sorted(intervals, 0, m - 1);
        //然后逐步合并
        int j = 0;  //j指向要与i做对比的最后一个区间的位置
        for (int i = 1; i < m; i++) { //i依次向后取
            if (intervals[j][1] >= intervals[i][0]) { //两个区间有交叉
                intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
            } else { //两个区间没有交叉，把i位置的向前挪，填补前面数组的空白
                j++;
                intervals[j] = intervals[i];
            }
        }
        return Arrays.copyOf(intervals, j + 1);
    }

    private void sorted(int[][] intervals, int left, int right) {
        //快速排序
        if (left >= right) {
            return;
        }
        int[] x = intervals[right];
        int index = left;
        for (int i = left; i < right; i++) {
            if (intervals[i][0] < x[0]) {
                int[] temp = intervals[index];
                intervals[index] = intervals[i];
                intervals[i] = temp;
                index++;
            }
        }
        intervals[right] = intervals[index];
        intervals[index] = x;
        sorted(intervals, left, index - 1);
        sorted(intervals, index + 1, right);

    }

    public static void main(String[] args) {
        int[][] init = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        System.out.println(Arrays.deepToString(init));
        new _07_mergeinterval().sorted(init, 0, init.length - 1);
        System.out.println(Arrays.deepToString(init));

        int[][] merge = new _07_mergeinterval().merge1(init);
//        new _07_mergeinterval().sorted(init, 0, init.length);

        System.out.println(Arrays.deepToString(merge));
    }


}
