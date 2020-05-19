package sort;

/**
 * 统计排序
 *
 * @author Sean
 * @date 2020/05/19
 */
public class CountSort {

    /**
     * 计数排序
     * 时间复杂度(平均)O(M+N)
     * 时间复杂度(最坏)O(M+N)
     * 时间复杂度(最好)O(M+N)
     * 空间复杂度O(M+N)
     * 局限性：
     * 1. 当数列最大最小值差距过大时，并不适用于计数排序
     * 2. 当数列元素不是整数时，并不适用于计数排序
     */
    public static int[] sort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int d = max - min;
        int[] countArr = new int[d + 1];
        //构建统计数组
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] - min]++;
        }
        //统计数组变形，后面的元素等于前面元素加上当前元素的和用于区分排序
        int sum = 0;
        for (int i = 0; i < countArr.length; i++) {
            sum += countArr[i];
            countArr[i] = sum;
        }
        //倒序输出排序元素
        int[] sortedArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArr[countArr[arr[i] - min] - 1] = arr[i];
            countArr[arr[i] - min]--;
        }
        return sortedArr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 6};
        int[] sort = sort(arr);
        for (int x : sort) {
            System.out.println(x);
        }
    }
}
