package offer;

/**
 * 斐波那契数列
 *
 * @author yejc
 * @date 2020/3/8 10:32
 */
public class Fibonacci {

    public int fibo(int n) {
        if (n < 2) {
            return n;
        }
        int one = 0;
        int two = 1;
        int three = 0;
        for (int i = 2; i <= n; i++) {
            three = one + two;
            one = two;
            two = three;
        }
        return three;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int i = fibonacci.fibo(10);
        System.out.println(i);
    }
}
