package hot100;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-13-18:15
 * @Desc:旋转图像
 */
public class _0048_rotate {

    public void rotate(int[][] matrix) {


        int n = matrix.length;

//        水平反转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - i - 1][j] = temp;

            }
        }
//        对角线反转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


    }
}
