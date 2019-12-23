package primary.design;

import java.util.Stack;

/**
 * 最小栈
 *
 * @author: yejc
 * @create: 2019-12-04 21:33
 */
public class MinStack2 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> helper = new Stack<>();

    public MinStack2() {

    }

    public void push(int x) {
        stack.push(x);
        if (helper.isEmpty() || helper.peek() > x) {
            helper.push(x);
        } else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        stack.pop();
        helper.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return helper.peek();
    }
}
