package org.datastructuresandalgorithms.hiskio.sort.insertionsort;

/**
 * 改造 Insertion_Sort 的寫法變成 遞迴
 * <p>
 * 改寫方式
 * <ul>
 *     <li>找出會遞增或遞減的變數。</li>
 *     舉例: 把 for(int i = 0; i < nums.length; i++)
 *     <li>抽出 int i = 0; 初始宣告</li>
 *     <li>接著因為 for 其實也是不斷呼叫自己的，所以創建的新的 function 去處理內容</li>
 *     <li>最後判斷條件是否成立</li>
 *     <li>把該變數抽出來呼叫自己，直到變數達到條件</li>
 * </ul>
 */
public class Sort_Insertion2_WithRecursion {
    public static void insertion_sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static void insertion_sort_recusion(int[] nums) {
        int round = 0;
        insertion_sort_recusion_01(nums, round);
    }

    private static void insertion_sort_recusion_01(int[] nums, int round) {
        if (round == nums.length) return;

        /** 第二層 for 做的處理 */
        int jRound = 1;
        insertion_sort_recusion_02(nums, jRound);
        /** 第二層 for 做的處理 */

        insertion_sort_recusion_01(nums, round + 1);
    }

    private static void insertion_sort_recusion_02(int[] nums, int jRound) {
        if (jRound == nums.length) return;

        /** 第二層 for 裡面的邏輯 */
        if (nums[jRound - 1] > nums[jRound]) {
            swap(nums, jRound - 1, jRound);
        } else {
            return;
        }
        /** 第二層 for 裡面的邏輯 */

        insertion_sort_recusion_02(nums, jRound + 1);
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1}; // 測試完全相反
//        int[] nums = {2, 1, 3, 4, 5}; // 測試部分已排序
        insertion_sort_recusion(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}