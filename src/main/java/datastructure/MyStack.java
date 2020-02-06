package datastructure;

import java.util.Arrays;

/**
 * 使用数组实现栈
 * 自己实现一个栈，要求这个栈具有push()、pop()（返回栈顶元素并出栈）、peek() （返回栈顶元素不出栈）、isEmpty()、size()这些基本的方法。
 * <p>
 * 每次入栈之前先判断栈的容量是否够用，如果不够用就用Arrays.copyOf()进行扩容；
 *
 * @author yejc
 * @date 2020/2/6 14:56
 */
public class MyStack
{
    /**
     * 存储元素的数组
     */
    private int[] arr;
    /**
     * 元素大小
     */
    private int size;

    public MyStack(int size)
    {
        arr = new int[size];
    }

    public void push(int value)
    {
        if (arr.length == size)
        {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[size++] = value;
    }

    public int pop()
    {
        if (size < 1)
        {
            throw new RuntimeException("栈内没有元素");
        }
        return arr[--size];
    }

    public int peek()
    {
        if (size < 1)
        {
            throw new RuntimeException("栈内没有元素");
        }
        return arr[size - 1];
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    public static void main(String[] args)
    {
        MyStack stack = new MyStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
