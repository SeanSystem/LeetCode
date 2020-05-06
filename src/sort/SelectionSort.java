package sort;

/**
 * 选择排序
 *
 * @author by Sean
 * @date 2020/4/29 22:25
 */
public class SelectionSort {

    /**
     * 选择排序(平均) O(n^2)
     * 选择排序(最坏) O(n^2)
     * 选择排序(最好) O(n^2)
     * 空间复杂度O(1)
     * 不稳定
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
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
