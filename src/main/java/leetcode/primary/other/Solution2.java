package leetcode.primary.other;

/**
 * @author yejc
 * @date 2019/12/24 20:32
 */
public class Solution2 {

    /**
     * 位1的个数
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    /**
     * 汉明距离
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int count = 0;
        int n = x ^ y;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    /**
     * 颠倒二进制位
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= n & 1;
            n >>= 1;
        }
        return res;
    }

}
