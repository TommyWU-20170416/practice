package org.datastructuresandalgorithms.hiskio.sort.bubblesort;

/**
 * 改造 Bubble_Sort 的寫法變成 遞迴
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
public class Sort_Bubble3 {
    public static void bubble_sort_recursion(int[] nums) {
        int round = 0;
        bubble_sort_recursion_01(nums, round);
    }

    public static void bubble_sort_recursion_01(int[] nums, int round) {
        if (round == nums.length) return;

        /** 第二層 for 做的處理 */
        int j_round = 1;
        bubble_sort_recursion_02(nums, j_round);
        /** 第二層 for 做的處理 */

        bubble_sort_recursion_01(nums, round + 1);
    }

    public static void bubble_sort_recursion_02(int[] nums, int jRound) {
        if (jRound == nums.length) return;

        /** 第二層 for 裡面的邏輯 */
        if (nums[jRound - 1] > nums[jRound]) swap(nums, jRound - 1, jRound);
        /** 第二層 for 裡面的邏輯 */

        bubble_sort_recursion_02(nums, jRound + 1);
    }


    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1}; // 測試完全相反
        bubble_sort_recursion(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
