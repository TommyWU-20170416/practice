package org.datastructuresandalgorithms.hiskio.tree;

public class QuickSort {
    public static void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * Q: 這邊是 preorder, inorder, postorder 哪一種
     * A: 由於是先 sort 在往下做，就像是 preorder 的先印，再往下做
     */
    public static void quickSort(int[] nums, int i_start, int i_end) {
        if (i_start == i_end) return;
        if (i_start > i_end) return;

        int i_pivot_guess = get_pivot_index(nums, i_start, i_end);     // System.out.print(node.val + " ");
        int i_pivot_final = sort(nums, i_start, i_pivot_guess, i_end); // System.out.print(node.val + " ");

        quickSort(nums, i_start, i_pivot_final - 1); // 如果看成是 binary tree 的 traverse_left_postorder(node.left);
        quickSort(nums, i_pivot_final + 1, i_end);   // 如果看成是 binary tree 的 traverse_left_postorder(node.right);
    }

    private static void swap(int[] nums, int i_meet, int i_pivot_now) {
        int tmp = nums[i_meet];
        nums[i_meet] = nums[i_pivot_now];
        nums[i_pivot_now] = tmp;
    }

    /**
     * 獲取 pivot 直接抓中間偏左
     */
    private static int get_pivot_index(int[] nums, int i_start, int i_end) {
        return (i_start + i_end) / 2;
    }

    /**
     * 實作 quicksort 主要邏輯
     */
    private static int sort(int[] nums, int i_start, int i_pivot_guess, int i_end) {
        int i_pivot_now = i_pivot_guess;

        // step01. swap pivot with last element
        swap(nums, i_pivot_now, i_end);
        i_pivot_now = i_end;

        // step02. build left and right index and start sort
        int i_left = i_start;
        int i_right = i_end - 1;

        while (true) {
            while (true) {
                if (i_left == i_right) break;
                if (nums[i_left] > nums[i_pivot_now]) break;
                i_left++;
            }
            while (true) {
                if (i_left == i_right) break;
                if (nums[i_right] < nums[i_pivot_now]) break;
                i_right--;
            }
            if (i_left == i_right) break;
            swap(nums, i_left, i_right);
        }
        // step03. when left meet right
        int i_meet = i_left;
        // 判斷相遇的點是否 > pivot ，有的話要交換
        if (nums[i_meet] > nums[i_pivot_now]) {
            swap(nums, i_meet, i_pivot_now);
            i_pivot_now = i_meet;
        }
        return i_pivot_now;
    }
}
