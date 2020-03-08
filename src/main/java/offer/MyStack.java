package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现栈
 *
 * @author yejc
 * @date 2020/3/7 21:42
 */
public class MyStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    private int n;

    public void push(int val) {
        if (n == 0 || !queue1.isEmpty()) {
            queue1.add(val);
        } else {
            queue2.add(val);
        }
    }

    public int pop() {
        if (n == 0) {
            throw new RuntimeException("Stack is empty.");
        }
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        } else {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
    }
}
