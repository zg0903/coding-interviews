package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-13-17:20
 * @Desc:螺旋矩阵
 */
public class _1_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int column = matrix[0].length;
        int count = 0;
        int total = row * column;
        int up = 0;
        int right = column - 1;
        int down = row - 1;
        int left = 0;
        while (count < total) {
            for (int i = left; i <= right && count < total; i++) {
                res.add(matrix[up][i]);
                count++;
            }
            up++;
            for (int i = up; i <= down && count < total; i++) {
                res.add(matrix[i][right]);
                count++;
            }
            right--;
            for (int i = right; i >= left && count < total; i--) {
                res.add(matrix[down][i]);
                count++;
            }
            down--;
            for (int i = down; i >= up && count < total; i--) {
                res.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return res;
    }


    public List<Integer> spiralOrderSelf(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int column = matrix[0].length;
        int total = row * column;
        int up = 0;
        int left = 0;
        int right = row - 1;
        int down = column - 1;
        int count = 0;
        while (count < total) {
            for (int i = left; i <= right && count < total; i++) {
                res.add(matrix[up][i]);
                count++;
            }
            up++;
            for (int i = up; i <= down && count < total; i++) {
                res.add(matrix[i][right]);
                count++;
            }
            right--;
            for (int i = right; i >= left && count < total; i--) {
                res.add(matrix[down][i]);
                count++;
            }
            down--;
            for (int i = down; i > up && count < total; i--) {
                res.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return res;


    }

}
