
public class Main {


    public static void main(String[] args) {
        int[] arr = {10, 9, 5, 4, 3, 2, 1, 8, 7, 6};
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        boolean isOk = true;
        int pos;
        int k = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            pos = 0;
            isOk = true;
            for (int j = 0; j < k; j++) {
                if (arr[j] > arr[j + 1]) {
                    isOk = false;
                    int temp = arr[j];
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

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int p = arr[left];
            while (i < j) {
                while (i < j && arr[j] >= p) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                while (i < j && arr[i] < p) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = p;
            sort(arr, left, i - 1);
            sort(arr, i + 1, right);
        }
    }
}
