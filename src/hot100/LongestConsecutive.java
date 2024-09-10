package hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }
        for (int num : nums) {
            if (!sets.contains(num - 1)) {
                int currentNum = num;
                int count = 1;
                while (sets.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                longest = Math.max(count, longest);
            }
        }
        return longest;
    }
}
