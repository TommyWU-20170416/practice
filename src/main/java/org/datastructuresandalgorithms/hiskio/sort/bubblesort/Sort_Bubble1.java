package org.datastructuresandalgorithms.hiskio.sort.bubblesort;

/**
 * https://hiskio.com/courses/465/lectures/23092
 * <p>
 * 實作 Bubble Sort
 * <p>
 * 只要左邊比右邊大的就交換，且一路比到底
 * <p>
 * Q: 想想這樣做有沒有可再優化的地方
 */
public class Sort_Bubble1 {
    public static void bubble_sort(int[] nums) {
        // 執行幾次
        int checkTimes = 0;
        // 總共要跑的次數
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                checkTimes++;
                // 左邊跟右邊比較，如果左邊大就交換
                if (nums[j - 1] > nums[j]) swap(nums, j - 1, j);
            }
        }
        System.out.println("總共檢查 " + checkTimes + " 次");
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
//        int[] nums = {2, 1, 3, 4, 5};
        bubble_sort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
