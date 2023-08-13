package zhihu.shuzu;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name zhihu
 * @date 2022-02-27-11:12
 * @Desc:
 */


public class FindIn2DArray {


    public static boolean Find(int[][] array, int target) {
        if (array != null || array.length > 0) {
            int n = array.length; // 总行数
            int col = array[0].length - 1; //列索引
            int row = 0; //行索引
//            array[row][col]是右上角的元素
            while (row < n && col >= 0) {
                if (target < array[row][col]) {
                    col--;
                } else if (target > array[row][col]) {
                    row++;
                } else {
                    return true;
                }
            }
            return false;

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println( FindIn2DArray.Find(array, 12));

    }
}
