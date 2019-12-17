package other;

public class Solution {

    /**
     * 位1的个数
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int result = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                result++;
            }
            mask <<= 1;
        }
        return result;
    }
}
