package offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * @author yejc
 * @date 2020/3/7 21:34
 */
public class MyQueue {
    private Stack<Integer> push = new Stack<>();
    private Stack<Integer> pop = new Stack<>();

    public void appendTail(int val) {
        push.push(val);
    }

    public int deleteHead() {
        if (pop.isEmpty()) {
            while (!push.isEmpty()) {
                pop.push((push.pop()));
            }
        }
        if (push.isEmpty()) {
            throw new RuntimeException("队列中无数据");
        }
        return pop.pop();
    }
}
