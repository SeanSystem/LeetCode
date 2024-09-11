package sort;

/**
 * 基数排序
 *
 * @author Sean
 * @date 2020/05/20
 */
public class RadixSort {

    /**
     * 时间复杂度(平均)O(n*k)
     * 时间复杂度(最坏)O(n*k)
     * 时间复杂度(最好)O(n*k)
     * 空间复杂度O(n+k)
     * 局限性：排序元素需要为整数
     */
    public static void sort(int[] arr) {
        int max = getMax(arr);
        int radix = 1;
        for (; max / radix > 0; radix *= 10) {
            radixSort(arr, radix);
        }
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void radixSort(int[] arr, int radix) {
        int[] bucket = new int[10];
        //桶元素计数
        for (int i = 0; i < arr.length; i++) {
            bucket[(arr[i] / radix) % 10]++;
        }
        //桶元素统计排名
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i - 1];
        }
        //倒序输出元素
        int[] temp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            temp[bucket[(arr[i] / radix) % 10] - 1] = arr[i];
            bucket[(arr[i] / radix) % 10]--;
        }
        //将排好序的元素
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
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
