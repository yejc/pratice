package sundry;

/**
 * @author yejc
 * @date 2020/2/20 15:33
 */
public class MaxContainer {

    /**
     * 11. 盛最多水的容器
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int high = Math.min(height[i], height[j]);
                int width = j - i;
                max = Math.max(max, high * width);
            }
        }
        return max;
    }
}
