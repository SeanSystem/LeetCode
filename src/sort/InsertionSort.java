package sort;

/**
 * 插入排序
 *
 * @author by Sean
 * @date 2020/4/29 22:48
 */
public class InsertionSort {

    /**
     * 时间复杂度（平均）O(n^2)
     * 时间复杂度（最坏）O(n^2)
     * 时间复杂度（最好）O(n)
     * 空间复杂度 O(1)
     * 稳定
     */
    public static void sort(int[] arr) {
        int preIndex;
        int current;
        for (int i = 1; i < arr.length; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
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
