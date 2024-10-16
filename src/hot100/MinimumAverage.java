package hot100;


import java.util.Arrays;

/**
 * 你有一个初始为空的浮点数数组 averages。另给你一个包含 n 个整数的数组 nums，其中 n 为偶数。
 * <p>
 * 你需要重复以下步骤 n / 2 次：
 * <p>
 * 从 nums 中移除 最小 的元素 minElement 和 最大 的元素 maxElement。
 * 将 (minElement + maxElement) / 2 加入到 averages 中。
 * 返回 averages 中的 最小 元素。
 */
public class MinimumAverage {

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double minAvg = 51;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            minAvg = Math.min(minAvg, (nums[left] + nums[right]) / 2.0);
            left++;
            right--;
        }
        return minAvg;
    }
}
