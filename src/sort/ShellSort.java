package sort;

/**
 * 希尔排序
 *
 * @author by Sean
 * @date 2020/5/6 20:18
 */
public class ShellSort {

    /**
     * 时间复杂度（平均）O(n^1.3)
     * 时间复杂度（最坏）O(n^2)
     * 时间复杂度（最好）O(n)
     * 空间复杂度O(1)
     * 不稳定
     */
    public static void sort(int[] arr) {
        int len = arr.length;
        for (int gap = (int) Math.floor(len / 2); gap > 0; gap = (int) Math.floor(gap / 2)) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 6};
        sort(arr);
        for (int x : arr) {
            System.out.println(x);
        }
    }

}
