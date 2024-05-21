package org.datastructuresandalgorithms.hiskio.tree;

public class MergeSort {

    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int i_start, int i_end) {
        if (i_start == i_end) return;

        int i_middle = (i_start + i_end) / 2;
        mergeSort(nums, i_start, i_middle);
        mergeSort(nums, i_middle + 1, i_end);

        sort(nums, i_start, i_middle, i_end);
    }

    private static void sort(int[] nums, int i_start, int i_middle, int i_end) {
        int[] nums_tmp = new int[nums.length]; // 預計merge 後的 tmp array
        int i_nums_tmp = i_start;
        int i_left = i_start;
        int i_right = i_middle + 1;

        while (true) {
            if (i_nums_tmp > i_end) break;

            Integer left = null;
            Integer right = null;
            // 挑選左右子陣列的元素做比對

            if (i_left <= i_middle) {
                left = nums[i_left];
            }
            if (i_right <= i_end) {
                right = nums[i_right];
            }

            // 會有3種比對狀況，要注意如果直一樣的時候也要處理到
            if (left != null && right != null) {
                if (left <= right) {
                    nums_tmp[i_nums_tmp] = left;
                    i_left++;
                } else if (left > right) {
                    nums_tmp[i_nums_tmp] = right;
                    i_right++;
                }
            } else if (left != null && right == null) {
                nums_tmp[i_nums_tmp] = left;
                i_left++;
            } else if (left == null && right != null) {
                nums_tmp[i_nums_tmp] = right;
                i_right++;
            }

            i_nums_tmp++;
        }

        // 把 tmp 放回原陣列
        for (int i = i_start; i <= i_end; i++) {
            nums[i] = nums_tmp[i];
        }
    }
}
