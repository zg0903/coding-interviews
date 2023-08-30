package hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-27-16:04
 * @Desc: 滑动窗口最大值
 */
public class _239_maxSlidingWindow {

//    单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d = new ArrayDeque<>();
        int n = nums.length, m = n - k + 1;
        int[] ans = new int[m];
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && nums[d.peekLast()] <= nums[i]) d.pollLast();
            d.addLast(i);
            if (i >= k - 1) {
                while (!d.isEmpty() && d.peekFirst() <= i - k) d.pollFirst();
                ans[i - k + 1] = nums[d.peekFirst()];
            }
        }
        return ans;
    }

//    优先队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int n = nums.length, m = n - k + 1, idx = 0;
        int[] ans = new int[m];
        for (int i = 0; i < n; i++) {
            q.add(new int[]{i, nums[i]});
            if (i >= k - 1) {
                while (q.peek()[0] <= i - k) q.poll();
                ans[idx++] = q.peek()[1];
            }
        }
        return ans;
    }


}
