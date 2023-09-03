package hot100;

import java.util.Stack;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-09-03-22:16
 * @Desc:
 */
public class _0155_MinStack2 {

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int x) {
        //当前值更小
        if (x <= min) {
            //将之前的最小值保存
            stack.push(min);
            //更新最小值
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        //如果弹出的值是最小值，那么将下一个元素更新为最小值
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }


}
