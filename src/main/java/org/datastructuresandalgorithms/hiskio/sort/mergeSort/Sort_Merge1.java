package org.datastructuresandalgorithms.hiskio.sort.mergeSort;

public class Sort_Merge1 {
    // 執行幾次
    private static int checkTimes = 0;

    public static void merge_sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            merge_sort(arr, l, m);
            merge_sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {5, 4, 3, 2, 1}; // 測試完全相反
        int[] nums = {3, 1, 5, 2, 4}; // 測試部分已排序
        merge_sort(nums, 0, nums.length - 1);

        System.out.println("總共檢查 " + checkTimes + " 次");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
