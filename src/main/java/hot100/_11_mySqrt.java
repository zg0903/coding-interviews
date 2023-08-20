package hot100;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-19-19:29
 * @Desc:x 的平方根
 */
public class _11_mySqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 0, right = x;
        int mid = (left + right) / 2;
        while (mid > x / mid || mid + 1 <= x / (mid + 1)) {
            if (mid > x / mid) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }


    public static void main(String[] args) {
        int i = new _11_mySqrt().mySqrt(36);
        System.out.println(i);
    }
}
