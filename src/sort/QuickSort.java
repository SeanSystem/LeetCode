package sort;

/**
 * 快速排序
 *
 * @author Sean
 * @date 2020/05/08
 */
public class QuickSort {

    /**
     * 时间复杂度（平均）O(nlog2 n)
     * 时间复杂度（最好）O(nlog2 n)
     * 时间复杂度（最坏）O(n^2)
     * 空间复杂度O(nlog2 n)
     * 不稳定
     */
    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int x = arr[left];
            while (i < j) {
                while (i < j && arr[j] >= x) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                while (i < j && arr[i] < x) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;
            //左分区排序
            sort(arr, left, i - 1);
            //右分区排序
            sort(arr, i + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        sort(arr, 0, arr.length - 1);
        for (int x : arr) {
            System.out.println(x);
        }
    }

}
