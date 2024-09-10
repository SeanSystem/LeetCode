package hot100;

public class MaxArea {

    public static int maxArea(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

}
