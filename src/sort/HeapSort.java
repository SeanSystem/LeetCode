package sort;

/**
 * 堆排序
 *
 * @author by Sean
 * @date 2020/5/18 22:42
 */
public class HeapSort {

    public static void sort(int[] arr) {
        int len = arr.length;
        //第一个非叶子节点
        int begin = len / 2 - 1;
        //从第一个非叶子结点从下至上，从右至左调整结构大顶堆
        for (int i = begin; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }
        //调整堆结构+交换堆顶元素与末尾元素
        for (int j = len - 1; j > 0; j--) {
            //交换堆顶和末尾元素
            swap(arr, 0, j);
            //从新对堆进行调整
            adjustHeap(arr, 0, j);
        }
    }

    public static void adjustHeap(int[] arr, int begin, int len) {
        int temp = arr[begin];
        for (int i = begin * 2 + 1; i < len; i = i * 2 + 1) {
            //判断左右节点元素大小
            if (i + 1 < len && arr[i] < arr[i + 1]) {
                i++;
            }
            //如果子节点元素大于父节点，将子节点直接赋值给父节点（无需交换）
            if (arr[i] > temp) {
                arr[begin] = arr[i];
                begin = i;
            } else {
                break;
            }
        }
        arr[begin] = temp;
    }

    /**
     * 交换元素
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 递归方式
     */
    public static void sort2(int[] arr) {
        /*
         *  第一步：将数组堆化
         *  beginIndex = 第一个非叶子节点。
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        int len = arr.length - 1;
        int begin = (len - 1) >> 1;
        for (int i = begin; i >= 0; i--) {
            maxHeapif(arr, i, len);
        }
        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
        for (int j = len; j > 0; j--) {
            swap(arr, 0, j);
            maxHeapif(arr, 0, j - 1);
        }
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     *
     * @param begin 需要堆化处理的数据的索引
     * @param len 未排序的堆（数组）的长度
     */
    private static void maxHeapif(int[] arr, int begin, int len) {
        // 左子节点索引
        int li = (begin << 1) + 1;
        // 右子节点索引
        int ri = li + 1;
        // 子节点值最大索引，默认左子节点。
        int cMax = li;
        // 左子节点索引超出计算范围，直接返回。
        if (li > len) return;
        // 先判断左右子节点，哪个较大。
        if (ri <= len && arr[ri] > arr[li]) {
            cMax = ri;
        }
        if (arr[cMax] > arr[begin]) {
            swap(arr, cMax, begin);
            // 如果父节点被子节点调换，则需要继续判断换下后的父节点是否符合堆的特性。
            maxHeapif(arr, cMax, len);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 6};
        //int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort2(arr);
        for (int x : arr) {
            System.out.println(x);
        }
    }
}
