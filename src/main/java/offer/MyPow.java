package offer;

/**
 * @author yejc
 * @date 2020/3/10 21:07
 */
public class MyPow {

    public double power(double base, int exponent) {
        if (base == 0 && exponent == 0) {
            return 0;
        }
        int absExponent = Math.abs(exponent);
        double result = powerWithPositiveExponent(base, absExponent);
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    private double powerWithPositiveExponent(double base, int absExponent) {
        double result = 1;
        for (int i = 0; i < absExponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.power(0,-2));
    }
}
