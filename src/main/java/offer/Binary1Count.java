package offer;

/**
 * 二进制中1的个数
 *
 * @author yejc
 * @date 2020/3/10 20:31
 */
public class Binary1Count {
    public int count(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Binary1Count binary1Count = new Binary1Count();
        System.out.println(binary1Count.count(100));
    }
}
