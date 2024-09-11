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
     * 时间复杂度(最坏) O(n^2)
     * 时间复杂度(最好) O(n)
     * 空间复杂度O(1)
     * 稳定
     */
    public static void sort(int[] arr) {
        //上一次数据交换位置
        int k = arr.length - 1;
        int pos;
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = 0;
            pos = 0;
            boolean isOk = true;
            for (int j = 0; j < k; j++) {
                if (arr[j] > arr[j + 1]) {
                    isOk = false;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    pos = j;
                }
            }
            if (isOk) {
                break;
            }
            k = pos;
        }
    }

    /**
     * 双向冒泡排序
     */
    public static void sort2(int[] arr) {
        int pos;
        int l = arr.length - 1;
        int r = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = 0;
            pos = 0;
            boolean isOk = true;
            //正向冒泡
            for (int j = r; j < l; j++) {
                if (arr[j] > arr[j + 1]) {
                    isOk = false;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    pos = j;
                }
            }
            l = pos;
            //反向冒泡
            for (int k = l; k > r; k--) {
                if (arr[k] < arr[k - 1]) {
                    isOk = false;
                    temp = arr[k];
                    arr[k] = arr[k - 1];
                    arr[k - 1] = temp;
                    pos = k;
                }
            }
            r = pos;
            if (isOk) {
                break;
            }
        }
    }

    public static void sort3(int[] arr) {
        int len = arr.length;
        int k = arr.length - 1;
        for (int i = 0; i < len - 1; i++) {
            int pos = 0;
            boolean sorted = true;
            for (int j = 0; j < k; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    sorted = false;
                    pos = j;
                }
            }
            if (sorted) {
                break;
            }
            k = pos;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] arr = {1, 2, 8, 7, 6, 5, 4, 3, 9, 10};
        sort3(arr);
        for (int x : arr) {
            System.out.println(x);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
    }
}
