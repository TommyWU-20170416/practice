package org.datastructuresandalgorithms.hiskio.sort.selectionsort;

/**
 * 改造 Selection_Sort 的寫法變成 遞迴
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
public class Sort_Selection3 {
    public static void selection_sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minLocation = -1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minLocation] > nums[j]) {
                    // 找出最小的 num 跟 位置
                    minLocation = j;
                }
            }
            // 如果 minLocation != -1 就交換，因為沒有找到也就沒有交換的必要性
            if (minLocation != -1) swap(nums, i, minLocation);
        }
    }

    public static void selection_sort_recursion(int[] nums) {
        int round = 0;
        selection_sort_recursion_01(nums, round);
    }

    private static void selection_sort_recursion_01(int[] nums, int round) {
        if (round == nums.length) return;
        int minLocation = round;

        /** 第二層 for 做的處理 */
        int jRound = round + 1;
        minLocation = selection_sort_recursion_02(nums, minLocation, jRound);
        /** 第二層 for 做的處理 */

        // 如果 minLocation != -1 就交換，因為沒有找到也就沒有交換的必要性
        if (minLocation != -1) swap(nums, round, minLocation);
        selection_sort_recursion_01(nums, round + 1);
    }

    private static Integer selection_sort_recursion_02(int[] nums, int minLocation, int jRound) {
        if (jRound == nums.length) return minLocation;

        /** 第二層 for 裡面的邏輯 */
        if (nums[minLocation] > nums[jRound]) {
            // 找出最小的 num 跟 位置
            minLocation = jRound;
        }
        /** 第二層 for 裡面的邏輯 */

        return selection_sort_recursion_02(nums, minLocation, jRound + 1);
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1}; // 測試完全相反
//        int[] nums = {2, 1, 3, 4, 5}; // 測試部分已排序
        selection_sort_recursion(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
