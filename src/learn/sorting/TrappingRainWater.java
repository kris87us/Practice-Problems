package learn.sorting;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.print(trappingRainWater(new int[]{4,2,0,3,2,5}));
    }

    private static int trappingRainWater(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;
        int max = 0;

        while (left < right) {
            if (height[left] > leftMax) leftMax = height[left];
            if (height[right] > rightMax) rightMax = height[right];

            if (leftMax < rightMax) {
                max += Math.max(0, leftMax - height[left]);
                left++;
            } else {
                max += Math.max(0, rightMax - height[right]);
                right--;
            }
        }
        return max;
    }
}
