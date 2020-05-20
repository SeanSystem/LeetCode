package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 桶排序
 *
 * @author Sean
 * @date 2020/05/20
 */
public class BucketSort {

    /**
     * 时间复杂度(平均)O(n+k)
     * 时间复杂度(最坏)O(n^2)
     * 时间复杂度(最好)O(n)
     * 空间复杂度O(n+k)
     * 稳定
     * 局限性：
     * 桶排序是计数排序的升级版
     * 1.需要根据数据的分布情况选择合适的映射函数将数据映射到桶中
     * 2.桶中元素的排序需要选择合适的排序方法
     */
    public static void sort(int[] arr, int bucketSize) {
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
        //设置桶大小
        int buckets = (int) Math.floor(d / bucketSize) + 1;
        List<Integer>[] bucket = new List[buckets];
        for (int i = 0; i < buckets; i++) {
            bucket[i] = new ArrayList<Integer>();
        }
        //利用映射函数将数组映射到桶中
        for (int i = 0; i < arr.length; i++) {
            bucket[(int) Math.floor((arr[i] - min) / bucketSize)].add(arr[i]);
        }
        int n = 0;
        //对每个桶中的元素排序
        for (int i = 0; i < buckets; i++) {
            if (bucket[i].size() > 0) {
                List<Integer> list = bucket[i];
                int[] temp = new int[list.size()];
                for (int j = 0; j < list.size(); j++) {
                    temp[j] = list.get(j);
                }
                //桶中元素排序算法
                QuickSort.sort(temp, 0, temp.length - 1);
                for (int k = 0; k < temp.length; k++) {
                    arr[n++] = temp[k];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 6};
        sort(arr, 2);
        for (int x : arr) {
            System.out.println(x);
        }
    }

}
