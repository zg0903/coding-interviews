package leetcode;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-10-20-22:36
 * @Desc:
 */


public class _04_findNumberIn2DArray {

    public static boolean findNumberIn2DArray_1(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;

    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(matrix.length);
        boolean numberIn2DArray_1 = _04_findNumberIn2DArray.findNumberIn2DArray_1(matrix, 5);
        System.out.println(numberIn2DArray_1);

    }


}
