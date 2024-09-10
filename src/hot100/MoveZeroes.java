package hot100;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,0,1,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int n = nums.length, slow = 0, fast = 0;
        while (fast < n) {
            if (nums[fast] != 0) {
                if (slow != fast) {
                    swap(nums, slow, fast);
                }
                slow++;
            }
            fast++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 3, 12};
        moveZeroes(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
