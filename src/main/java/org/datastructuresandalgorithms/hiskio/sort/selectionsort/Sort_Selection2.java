package org.datastructuresandalgorithms.hiskio.sort.selectionsort;

/**
 * https://hiskio.com/courses/465/lectures/23093
 * <p>
 * 實作 Selection Sort
 * <p>
 * 挑出最小的跟當下做交換
 * <p>
 * Q: 想想這樣做有沒有可再優化的地方
 * A:
 * <ul>
 *     <li> if (nums[i] > nums[j]) 這邊可以把 i 換成 minLocation </li>
 *     原因: 原本的都是固定用 nums[i] 去做比對，但是如果 nums[i] 是最大的，怎麼比都會 > 讓最小值找得比較慢
 *     但如果把 i 改成 最小的 index，就真的會找到最小的值去做交換
 *     <li>若沒有找到最小的就不用交換</li>
 * </ul>
 */
public class Sort_Selection2 {
    public static void selection_sort(int[] nums) {
        // 執行幾次
        int checkTimes = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int minLocation = i;
            for (int j = i + 1; j < nums.length; j++) {
                checkTimes++;
                if (nums[minLocation] > nums[j]) {
                    // 找出最小的 num 跟 位置
                    minLocation = j;
                }
            }
            // 如果 minLocation != i 就交換，因為沒有找到也就沒有交換的必要性
            if (minLocation != i) swap(nums, i, minLocation);
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
        selection_sort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
