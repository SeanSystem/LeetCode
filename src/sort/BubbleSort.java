package sort;

/**
 * 冒泡排序
 *
 * @author by Sean
 * @date 2020/4/29 21:15
 */
public class BubbleSort {

    /**
     * 时间复杂度(平均) O(n^2)
     * 时间复杂度(平均) O(n^2)
     * 时间复杂度(最好) O(n)
     * 空间复杂度O(1)
     * 稳定
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = 0;
            boolean isOk = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isOk = false;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (isOk) {
                break;
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
