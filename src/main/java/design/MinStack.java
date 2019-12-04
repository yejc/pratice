package design;

import java.util.Stack;

/**
 * 最小栈
 *
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2019-12-04 21:33
 **/
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (helper.isEmpty() || helper.peek() >= x) {
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
