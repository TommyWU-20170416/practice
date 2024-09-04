package org.datastructuresandalgorithms.hiskio.sort.bubblesort;

/**
 * GPT 提供的優化方式
 * <p>
 * 實作 Bubble Sort
 * <p>
 * 只要左邊比右邊大的就交換，且一路比到底，但排過的就不用排
 * <p>
 * Q: 想想這樣做有沒有可再優化的地方
 * A:
 * <ul>
 *     <li>當有序的時候，使用一個 isSwapped 表示 是否交換過</li>
 *     <li>如果為 false 表示已經是一個排序好的，這樣可以降低檢查次數</li>
 * </ul>
 */
public class Sort_Bubble3 {
    private static boolean isSwapped;
    public static void bubble_sort(int[] nums) {
        // 執行幾次
        int checkTimes = 0;
        // 總共要跑的次數
        for (int round = 0; round < nums.length; round++) {
            // 因為每跑一個 round ，就會確定一個已經是最大的且已經定位的數字，就不用再異動
            // 所以把長度減去回合
            isSwapped = false;
            int len = nums.length - round;
            for (int j = 1; j < len; j++) {
                checkTimes++;
                // 左邊跟右邊比較，如果左邊大就交換
                if (nums[j - 1] > nums[j]) swap(nums, j - 1, j);
            }
            if (!isSwapped) {
                break;
            }
        }

        System.out.println("總共檢查 " + checkTimes + " 次");
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
        isSwapped = true;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1}; // 測試完全相反
//        int[] nums = {2, 1, 3, 4, 5}; // 測試部分已排序
        bubble_sort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
