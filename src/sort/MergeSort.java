package sort;

/**
 * 归并排序
 *
 * @author by Sean
 * @date 2020/5/6 21:00
 */
public class MergeSort {

    /**
     * 时间复杂度（平均）O(nlog2 n)
     * 时间复杂度（最坏）O(nlog2 n)
     * 时间复杂度（最好）O(nlog2 n)
     * 空间复杂度O(n)
     */
    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //左边序列排序
            sort(arr, left, mid, temp);
            //右边序列排序
            sort(arr, mid + 1, right, temp);
            //合并两有序列
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //左指针
        int i = left;
        //右指针
        int j = mid + 1;
        int t = 0;
        //左右有序列比较
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //左有序列剩余值处理
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        //右有序列剩余值处理
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        //将有序列复制到原数组
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 6};
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
        for (int x : arr) {
            System.out.println(x);
        }
    }
}
