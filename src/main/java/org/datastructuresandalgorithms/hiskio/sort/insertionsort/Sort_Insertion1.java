package org.datastructuresandalgorithms.hiskio.sort.insertionsort;

/**
 * https://hiskio.com/courses/465/lectures/23095
 * <p>
 * 實作 Insertion Sort
 * <p>
 * 只要左邊比右邊大的就交換，如果找不到就可以終止這一 round，減少檢查次數
 */
public class Sort_Insertion1 {
    public static void insertion_sort(int[] nums) {
        // 執行幾次
        int checkTimes = 0;

        // 總共要跑的次數
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                checkTimes++;
                if (nums[j - 1] > nums[j]) swap(nums, j - 1, j);
                else {
                    break;
                }
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
        int[] nums = {5, 4, 3, 2, 1}; // 測試完全相反
//        int[] nums = {2, 1, 3, 4, 5}; // 測試部分已排序
        insertion_sort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
