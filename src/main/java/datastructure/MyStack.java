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
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        System.out.println(myStack.peek());//8
        System.out.println(myStack.size());//8
        for (int i = 0; i < 8; i++) {
            System.out.println(myStack.pop());
        }
        System.out.println(myStack.isEmpty());//true
        myStack.pop();//报错：java.lang.IllegalArgumentException: Stack is empty.
    }
}
